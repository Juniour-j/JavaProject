package com.controlers;
import com.dto.*;
import com.mappers.UserMapper;
import com.models.Role;
import com.models.User;
import com.services.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * Controller for handling admin user management.
 */
@Controller
@RequestMapping("/managers")
public class ManagerController {

    private final UserService userService;
    private final UserMapper userMapper;

    @Autowired
    public ManagerController(UserService userService, UserMapper userMapper) { // we are using constructor injection
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping
    public String listManagers(Model model, HttpSession session) {
        if (!isAuthenticated(session)) return "redirect:/login";

        List<User> managers = userService.getAllUsersByRole(Role.ADMIN); // we are using the role ADMIN to get all managers
        List<UserDTO> managerDTOs = userMapper.toDTOList(managers); // we are using the mapper to convert the list of managers to DTOs
        model.addAttribute("managers", managerDTOs); // we are adding the list of managers to the model
        return "managers/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model, HttpSession session) {
        if (!isAuthenticated(session)) return "redirect:/login";

        model.addAttribute("user", new UserDTO()); // create a new empty DTO for the form
        return "managers/form";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model, HttpSession session) {
        if (!isAuthenticated(session)) return "redirect:/login";

        User user = userService.getUserById(id).orElseThrow(() ->  // lambda expression to handle the case when the user is not found
                new IllegalArgumentException("Invalid manager ID: " + id));
        model.addAttribute("user", userMapper.toDTOWithPassword(user));
        return "managers/form";
    }

    @PostMapping("/save")
    public String saveManager(@Valid @ModelAttribute("user") UserDTO userDTO, // we are using the DTO to bind the form data
                              BindingResult result,
                              RedirectAttributes redirectAttributes,
                              HttpSession session) {
        if (!isAuthenticated(session)) return "redirect:/login";

        if (result.hasErrors()) return "managers/form";

        try {
            if (userDTO.getId() == null) {
                userService.registerUser(userMapper.toEntity(userDTO), Role.ADMIN); // we are using the mapper to convert the DTO to entity
            } else {
                User existing = userService.getUserById(userDTO.getId()).orElseThrow();
                existing.setUsername(userDTO.getUsername()); // update the existing user
                existing.setEmail(userDTO.getEmail());
                existing.setLastName(userDTO.getLastName());
                userService.saveUser(existing);
            }
            redirectAttributes.addFlashAttribute("success", "Manager saved successfully!");
        } catch (IllegalArgumentException e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
            return "redirect:/managers/add";
        }

        return "redirect:/managers";
    }

    @GetMapping("/delete/{id}")
    public String deleteManager(@PathVariable Long id, RedirectAttributes redirectAttributes, HttpSession session) {
        if (!isAuthenticated(session)) return "redirect:/login";
        userService.deleteUser(id);
        redirectAttributes.addFlashAttribute("success", "Manager deleted successfully!");
        return "redirect:/managers";
    }

    private boolean isAuthenticated(HttpSession session) {
        Boolean authenticated = (Boolean) session.getAttribute("authenticated");
        return authenticated != null && authenticated;
    }
}

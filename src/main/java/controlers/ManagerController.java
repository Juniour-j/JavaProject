package controlers;
import DTO.*;
import models.*;

import services.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import mappers.*;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Controller
@RequestMapping("/managers")
public class ManagerController {

    @Autowired private UserService userService;

    @GetMapping
    public String list(Model model, HttpSession session) {
        if (!isAuthenticated(session)) return "redirect:/login";
        List<User> managers = userService.getAllUsersByRole(Role.MANAGER);
        model.addAttribute("managers", managers);
        return "managers/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes ra, HttpSession session) {
        if (!isAuthenticated(session)) return "redirect:/login";
        userService.deleteUser(id);
        ra.addFlashAttribute("success", "Manager deleted!");
        return "redirect:/managers";
    }

    private boolean isAuthenticated(HttpSession session) {
        Boolean authenticated = (Boolean) session.getAttribute("authenticated");
        return authenticated != null && authenticated;
    }
}


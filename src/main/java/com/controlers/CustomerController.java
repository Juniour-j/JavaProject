package com.controlers;
import com.dto.*;
import com.mappers.*;
import com.services.*;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
@Controller
@RequestMapping("/customers")
public class CustomerController {

    @Autowired private CustomerService customerService;
    @Autowired private CustomerMapper customerMapper;

    @GetMapping
    public String list(Model model, HttpSession session) {
        if (!isAuthenticated(session)) return "redirect:/login";
        model.addAttribute("customers", customerMapper.toDTOList(customerService.getAllCustomers())); // we use the mapper to convert the list of customers to DTOs
        return "customers/list";
    }

    @GetMapping("/add")
    public String add(Model model, HttpSession session) {
        if (!isAuthenticated(session)) return "redirect:/login";
        model.addAttribute("customer", new CustomerDTO()); // create a new CustomerDTO object
        return "customers/form";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model, HttpSession session) {
        if (!isAuthenticated(session)) return "redirect:/login";
        model.addAttribute("customer", customerMapper.toDTO(
                customerService.getCustomerById(id).orElseThrow())); // convert the customer entity to DTO
        return "customers/form";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("customer") CustomerDTO dto, BindingResult result,
                       RedirectAttributes ra, HttpSession session) {
        if (!isAuthenticated(session)) return "redirect:/login";
        if (result.hasErrors()) return "customers/form";
        customerService.saveCustomer(customerMapper.toEntity(dto)); // convert the DTO to entity
        ra.addFlashAttribute("success", "Customer saved!");
        return "redirect:/customers";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes ra, HttpSession session) {
        if (!isAuthenticated(session)) return "redirect:/login";
        customerService.deleteCustomer(id); // delete the customer by ID
        ra.addFlashAttribute("success", "Customer deleted!");
        return "redirect:/customers";
    }

    private boolean isAuthenticated(HttpSession session) {
        Boolean authenticated = (Boolean) session.getAttribute("authenticated");
        return authenticated != null && authenticated;
    }
}
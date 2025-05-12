package controlers;
import DTO.*;
import models.*;
import mappers.*;
import services.*;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;
import java.util.Set;
@Controller
@RequestMapping("/purchases")
class PurchaseController {

    @Autowired private PurchaseService purchaseService;
    @Autowired private CustomerService customerService;
    @Autowired private ProductService productService;
    @Autowired private PurchaseMapper purchaseMapper;

    @GetMapping
    public String list(Model model, HttpSession session) {
        if (!isAuthenticated(session)) return "redirect:/login";
        model.addAttribute("purchases", purchaseMapper.toDTOList(purchaseService.getAllPurchases()));
        return "purchases/list";
    }

    @GetMapping("/add")
    public String add(Model model, HttpSession session) {
        if (!isAuthenticated(session)) return "redirect:/login";
        model.addAttribute("purchase", new PurchaseDTO());
        model.addAttribute("customers", customerService.getAllCustomers());
        model.addAttribute("products", productService.getAllProducts());
        return "purchases/form";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("purchase") PurchaseDTO dto, BindingResult result,
                       RedirectAttributes ra, HttpSession session) {
        if (!isAuthenticated(session)) return "redirect:/login";
        if (result.hasErrors()) return "purchases/form";
        purchaseService.savePurchase(purchaseMapper.toEntity(dto));
        ra.addFlashAttribute("success", "Purchase recorded!");
        return "redirect:/purchases";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes ra, HttpSession session) {
        if (!isAuthenticated(session)) return "redirect:/login";
        purchaseService.deletePurchase(id);
        ra.addFlashAttribute("success", "Purchase deleted!");
        return "redirect:/purchases";
    }

    private boolean isAuthenticated(HttpSession session) {
        Boolean authenticated = (Boolean) session.getAttribute("authenticated");
        return authenticated != null && authenticated;
    }
}
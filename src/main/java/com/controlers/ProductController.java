package com.controlers;
import com.dto.*;
import com.models.*;
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

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    private final CategoryService categoryService;
    private final StoreService storeService;
    private final ProductMapper productMapper;

    @Autowired
    public ProductController(ProductService productService, CategoryService categoryService,
                             StoreService storeService, ProductMapper productMapper) {
        this.productService = productService;
        this.categoryService = categoryService;
        this.storeService = storeService;
        this.productMapper = productMapper;
    }

    @GetMapping
    public String listProducts(Model model, HttpSession session) {
        if (!isAuthenticated(session)) return "redirect:/login";
        List<ProductDTO> products = productMapper.toDTOList(productService.getAllProducts());
        model.addAttribute("products", products);
        return "products/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model, HttpSession session) {
        if (!isAuthenticated(session)) return "redirect:/login";
        model.addAttribute("product", new ProductDTO());
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("stores", storeService.getAllStores());
        return "products/form";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model, HttpSession session) {
        if (!isAuthenticated(session)) return "redirect:/login";
        Product product = productService.getProductById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid product ID: " + id));
        model.addAttribute("product", productMapper.toDTO(product));
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("stores", storeService.getAllStores());
        return "products/form";
    }

    @PostMapping("/save")
    public String saveProduct(@Valid @ModelAttribute("product") ProductDTO productDTO,
                              BindingResult result,
                              RedirectAttributes redirectAttributes,
                              HttpSession session) {
        if (!isAuthenticated(session)) return "redirect:/login";
        if (result.hasErrors()) return "products/form";
        productService.saveProduct(productMapper.toEntity(productDTO));
        redirectAttributes.addFlashAttribute("success", "Product saved successfully!");
        return "redirect:/products";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id, RedirectAttributes redirectAttributes, HttpSession session) {
        if (!isAuthenticated(session)) return "redirect:/login";
        productService.deleteProduct(id);
        redirectAttributes.addFlashAttribute("success", "Product deleted successfully!");
        return "redirect:/products";
    }

    private boolean isAuthenticated(HttpSession session) {
        Boolean authenticated = (Boolean) session.getAttribute("authenticated");
        return authenticated != null && authenticated;
    }
}

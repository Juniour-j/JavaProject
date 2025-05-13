package com.controlers;
import com.DTO.*;

import com.services.*;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.mappers.*;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    @Autowired private CategoryService categoryService;
    @Autowired private CategoryMapper categoryMapper;

    @GetMapping
    public String list(Model model, HttpSession session) {
        if (!isAuthenticated(session)) return "redirect:/login";
        model.addAttribute("categories", categoryMapper.toDTOList(categoryService.getAllCategories()));
        return "categories/list";
    }

    @GetMapping("/add")
    public String add(Model model, HttpSession session) {
        if (!isAuthenticated(session)) return "redirect:/login";
        model.addAttribute("category", new CategoryDTO());
        return "categories/form";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model, HttpSession session) {
        if (!isAuthenticated(session)) return "redirect:/login";
        model.addAttribute("category", categoryMapper.toDTO(
                categoryService.getCategoryById(id).orElseThrow()));
        return "categories/form";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("category") CategoryDTO dto, BindingResult result,
                       RedirectAttributes ra, HttpSession session) {
        if (!isAuthenticated(session)) return "redirect:/login";
        if (result.hasErrors()) return "categories/form";
        categoryService.saveCategory(categoryMapper.toEntity(dto));
        ra.addFlashAttribute("success", "Category saved!");
        return "redirect:/categories";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes ra, HttpSession session) {
        if (!isAuthenticated(session)) return "redirect:/login";
        categoryService.deleteCategory(id);
        ra.addFlashAttribute("success", "Category deleted!");
        return "redirect:/categories";
    }

    private boolean isAuthenticated(HttpSession session) {
        Boolean authenticated = (Boolean) session.getAttribute("authenticated");
        return authenticated != null && authenticated;
    }
}

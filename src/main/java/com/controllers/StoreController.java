package com.controllers;
import com.dto.*;
import com.mappers.*;
import com.models.Store;
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
@RequestMapping("/stores")
public class StoreController {

    @Autowired private StoreService storeService;
    @Autowired private StoreMapper storeMapper;

    @GetMapping
    public String list(Model model, HttpSession session) {
        if (!isAuthenticated(session)) return "redirect:/login";
        model.addAttribute("stores", storeMapper.toDTOList(storeService.getAllStores()));
        return "stores/list";
    }

    @GetMapping("/add")
    public String add(Model model, HttpSession session) {
        if (!isAuthenticated(session)) return "redirect:/login";
        model.addAttribute("store", new StoreDTO());
        return "stores/form";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model, HttpSession session) {
        if (!isAuthenticated(session)) return "redirect:/login";
        model.addAttribute("store", storeMapper.toDTO(
                storeService.getStoreById(id).orElseThrow()));
        return "stores/form";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("store") StoreDTO dto, BindingResult result,
                       RedirectAttributes ra, HttpSession session) {
        if (!isAuthenticated(session)) return "redirect:/login";
        if (result.hasErrors()) return "stores/form";
        storeService.saveStore(storeMapper.toEntity(dto));
        ra.addFlashAttribute("success", "Store saved!");
        return "redirect:/stores";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes ra, HttpSession session) {
        if (!isAuthenticated(session)) return "redirect:/login";
        storeService.deleteStore(id);
        ra.addFlashAttribute("success", "Store deleted!");
        return "redirect:/stores";
    }
    @GetMapping("/details/{id}")
    public String details(@PathVariable Long id, Model model, HttpSession session) {
        if (!isAuthenticated(session)) return "redirect:/login";

        Store store = storeService.getStoreById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid store ID: " + id));
        model.addAttribute("store", storeMapper.toDTO(store));
        return "stores/details";
    }
    @GetMapping("/search")
    public String search(@RequestParam("search") String searchText, Model model, HttpSession session) {
        if (!isAuthenticated(session)) return "redirect:/login";
        List<Store> result = storeService.searchStoresByNameOrLocation(searchText);
        model.addAttribute("stores", storeMapper.toDTOList(result));
        model.addAttribute("search", searchText);
        return "stores/list";
    }
    private boolean isAuthenticated(HttpSession session) {
        Boolean authenticated = (Boolean) session.getAttribute("authenticated");
        return authenticated != null && authenticated;
    }
}

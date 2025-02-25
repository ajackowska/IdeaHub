package pl.project.ideahub.category.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.project.ideahub.category.domain.model.Category;
import pl.project.ideahub.category.service.CategoryService;

import java.util.UUID;

@Controller
@RequestMapping("/admin/categories")
public class   CategoryViewController {

    private final CategoryService categoryService;

    public CategoryViewController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public String indexView(Model model) {
        model.addAttribute("categories", categoryService.getCategories());
        return "admin/category/index";
    }

    @GetMapping("{id}")
    public String editView(Model model, @PathVariable UUID id) {
        model.addAttribute("category", categoryService.getCategory(id));
        return "admin/category/edit";
    }

    @PostMapping("{id}")
    public String edit(@ModelAttribute("category") Category category, @PathVariable UUID id) {
        categoryService.updateCategory(id, category);
        return "redirect:/admin/categories";
    }
}

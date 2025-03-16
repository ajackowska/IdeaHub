package pl.project.ideahub.category.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.project.ideahub.category.domain.model.Category;
import pl.project.ideahub.category.service.CategoryService;
import pl.project.ideahub.question.domain.model.Question;
import pl.project.ideahub.question.service.QuestionService;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/categories")
public class CategoryViewController {

    private final CategoryService categoryService;
    private final QuestionService questionService;

    public CategoryViewController(CategoryService categoryService, QuestionService questionService) {
        this.categoryService = categoryService;
        this.questionService = questionService;
    }

    @GetMapping("{id}")
    public String singleView(Model model, @PathVariable UUID id) {
        Category category = categoryService.getCategory(id);
        List<Question> questions = questionService.findAllByCategoryId(id);

        // Diagnostyka
        System.out.println("Category: " + category);
        System.out.println("Questions: " + questions);

        model.addAttribute("category", category);
        model.addAttribute("questions", questions);
        return "category/single";
    }
}

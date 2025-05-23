package pl.project.ideahub.question.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.project.ideahub.category.service.CategoryService;
import pl.project.ideahub.question.domain.model.Question;
import pl.project.ideahub.question.service.AnswerService;
import pl.project.ideahub.question.service.QuestionService;

import java.util.UUID;

@Controller
@RequestMapping("/questions")
public class QuestionViewController {

    private final QuestionService questionService;
    private final AnswerService answerService;
    private final CategoryService categoryService;

    public QuestionViewController(QuestionService questionService,
                                  AnswerService answerService,
                                  CategoryService categoryService) {
        this.questionService = questionService;
        this.answerService = answerService;
        this.categoryService = categoryService;
    }

    @GetMapping
    public String indexView(Model model) {
        model.addAttribute("questions", questionService.getQuestions());
        model.addAttribute("categories", categoryService.getCategories());

        return "question/index";
    }

    @GetMapping("{id}")
    public String singleView(Model model, @PathVariable UUID id){
        model.addAttribute("question", questionService.getQuestion(id));
        model.addAttribute("answers", answerService.getAnswers(id));
        model.addAttribute("categories", categoryService.getCategories());
        return "question/single";
    }

    @GetMapping("add")
    public String addView(Model model){
        model.addAttribute("question", new Question());

        return "question/add";
    }

    @PostMapping
    public String add(Question question){
        questionService.createQuestion(question);
        return "redirect:/questions";
    }
}

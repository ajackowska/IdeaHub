package pl.project.ideahub;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("questions")
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService, IdeaHubConfiguration ideaHubConfiguration) {
        this.questionService = questionService;
    }

    @GetMapping
    public List<Question> getQuestions() {
        return questionService.getQuestions();
    }

    @GetMapping("/test")
    public String test(@RequestParam String value) {
        return questionService.test(value);
    }

}

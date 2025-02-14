package pl.project.ideahub.question.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.project.ideahub.question.domain.model.Answer;
import pl.project.ideahub.question.service.AnswerService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/questions/{questionId}/answers")
public class AnswerController {

    private final AnswerService answerService;

    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @GetMapping
    public List<Answer> getAnswers(@PathVariable("questionId") UUID questionId) {
        return answerService.getAnswers(questionId);
    }

    @GetMapping("{answerId}")
    public Answer getAnswer(@PathVariable UUID questionId, @PathVariable UUID answerId) {
        return answerService.getAnswer(answerId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Answer createAnswer(@PathVariable UUID questionId, @RequestBody Answer answer) {
        return answerService.createAnswer(questionId, answer);
    }

    @PutMapping("{answerId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Answer updateAnswer(@PathVariable String questionId, @PathVariable UUID answerId,
                               @RequestBody Answer answer) {
        return answerService.updateAnswer(answerId, answer);
    }

    @DeleteMapping("{answerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAnswer(@PathVariable UUID answerId) {
        answerService.deleteAnswer(answerId);
    }













//    @GetMapping
//    public List<An> getQuestions() {
//        return questionService.getQuestions();
//    }
//
//    @GetMapping("{id}")
//    public Question getQuestion(@PathVariable UUID id) {
//        return questionService.getQuestion(id);
//    }
//
//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public Question createQuestion(@RequestBody Question question) {
//        return questionService.createQuestion(question);
//    }
//
//    @PutMapping("{id}")
//    @ResponseStatus(HttpStatus.ACCEPTED)
//    public Question updateQuestion(@PathVariable UUID id, @RequestBody Question question) {
//        return questionService.updateQuestion(id, question);
//    }
//
//    @DeleteMapping("{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void deleteQuestion(@PathVariable UUID id) {
//        questionService.deleteQuestion(id);
//    }



}

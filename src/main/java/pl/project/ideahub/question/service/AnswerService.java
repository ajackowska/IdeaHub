package pl.project.ideahub.question.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.project.ideahub.question.domain.model.Answer;
import pl.project.ideahub.question.domain.model.Question;
import pl.project.ideahub.question.domain.repository.AnswerRepository;
import pl.project.ideahub.question.domain.repository.QuestionRepository;

import java.util.List;
import java.util.UUID;

@Service
public class AnswerService {

    private final AnswerRepository answerRepository;

    private final QuestionService questionService;
    private final QuestionRepository questionRepository;

    public AnswerService(AnswerRepository answerRepository, QuestionService questionService, QuestionRepository questionRepository) {
        this.answerRepository = answerRepository;
        this.questionService = questionService;
        this.questionRepository = questionRepository;
    }

    @Transactional(readOnly = true)
    public List<Answer> getAnswers(UUID questionId) {
        return answerRepository.findByQuestionId(questionId);
    }

    @Transactional(readOnly = true)
    public Answer getAnswer(UUID id) {
        return answerRepository.getById(id);
    }

    @Transactional
    public void deleteAnswer(UUID answerId) {
        answerRepository.deleteById(answerId);
    }

    @Transactional
    public Answer createAnswer(UUID questionId, Answer answerRequest) {
        Answer answer = new Answer();
        answer.setName(answerRequest.getName());
        Question question = questionRepository.getById(questionId);
        question.addAnswer(answer);
        answerRepository.save(answer);
        questionRepository.save(question);
        return answer;
    }

    @Transactional
    public Answer updateAnswer(UUID answerId, Answer answerRequest) {
        Answer answer = answerRepository.getById(answerId);
        answer.setName(answerRequest.getName());
        return answerRepository.save(answer);
    }
}

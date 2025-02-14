package pl.project.ideahub.question.service;

import org.springframework.stereotype.Service;
import pl.project.ideahub.question.domain.model.Answer;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class AnswerService {
    public List<Answer> getAnswers(UUID questionId) {
        return Arrays.asList(
                new Answer("answer 1"),
                new Answer("answer 2")
        );
    }

    public Answer getAnswer(UUID id) {
        return new Answer("answer " + id);
    }

    public void deleteAnswer(UUID id) {
    }

    public Answer createAnswer(UUID questionId, Answer answer) {
        return null;
    }

    public Answer updateAnswer(UUID id, Answer answer) {
        return null;
    }
}

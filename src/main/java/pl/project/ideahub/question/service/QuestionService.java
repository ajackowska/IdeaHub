package pl.project.ideahub.question.service;

import org.springframework.stereotype.Service;
import pl.project.ideahub.IdeaHubConfiguration;
import pl.project.ideahub.question.domain.model.Question;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class QuestionService {

    public List<Question> getQuestions() {
        return Arrays.asList(
                new Question("question1"),
                new Question("question2")
        );
    }

    public Question getQuestion(UUID id) {
        return new Question("question " + id);
    }

    public Question createQuestion(Question question) {
        question.setId(UUID.randomUUID());
        return question;
    }

    public Question updateQuestion(UUID id, Question question) {
        return question;
    }

    public void deleteQuestion(UUID id) {

    }
}

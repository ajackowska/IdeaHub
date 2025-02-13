package pl.project.ideahub;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class QuestionService {

    private final IdeaHubConfiguration ideaHubConfiguration;

    public QuestionService(IdeaHubConfiguration ideaHubConfiguration) {
        this.ideaHubConfiguration = ideaHubConfiguration;
    }

    public List<Question> getQuestions() {
        return Arrays.asList(
                new Question("question1"),
                new Question("question2")
        );
    }

    public String test(String value) {
        return String.format("Hello %s %s ", ideaHubConfiguration.getName(), value);

    }
}

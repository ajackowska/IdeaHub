package pl.project.ideahub.question.domain.model;

import jakarta.persistence.*;
import pl.project.ideahub.category.domain.model.Category;

import java.util.*;

@Entity
@Table(name = "questions")
public class Question {

    @Id
    private UUID id;

    private String name;

    @ManyToOne
//    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "question")
    private Set<Answer> answers;

    public Question() {
        this.id = UUID.randomUUID();
    }

    public Question(String name) {
        this();
        this.name = name;
    }

    public Set<Answer> getAnswers() {
        return Collections.unmodifiableSet(answers);
    }

    public Question addAnswer(Answer answer) {
        if (answers == null) {
            answers = new LinkedHashSet<Answer>();
        }
        answer.setQuestion(this);
        answers.add(answer);
        return this;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

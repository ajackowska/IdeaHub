package pl.project.ideahub.category.service;

import org.springframework.stereotype.Service;
import pl.project.ideahub.category.domain.model.Category;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class CategoryService {

    public List<Category> getCategories() {
        return Arrays.asList(
                new Category("category 1"),
                new Category("category 2"),
                new Category("category 3")
        );
    }

    public Category getCategory(UUID id) {
        return new Category("category " + id);
    }

    public Category createCategory(Category category) {
        category.setId(UUID.randomUUID());
        return category;
    }

    public Category updateCategory(UUID id, Category category) {
        return category;
    }

    public void deleteCategory(UUID id) {
    }
}

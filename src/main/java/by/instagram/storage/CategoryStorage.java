package by.instagram.storage;

import by.instagram.entity.Category;

import java.util.List;

public interface CategoryStorage {

    void saveCategory(Category category);

    Category getCategoryById( long idCategory);

    List<Category> getAllCategories();
}

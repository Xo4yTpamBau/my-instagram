package by.instagram.service;

import by.instagram.entity.Category;
import by.instagram.storage.CategoryStorage;
import by.instagram.storage.db.DBCategoryStorage;

import java.util.List;

public class CategoryService {
    private final CategoryStorage categoryStorage = new DBCategoryStorage();

    public void saveCategory(Category category) {
        categoryStorage.saveCategory(category);
    }

    public Category getCategoryById(long id) {
        return categoryStorage.getCategoryById(id);
    }

    public List<Category> getAllCategories() {
        return categoryStorage.getAllCategories();
    }


}


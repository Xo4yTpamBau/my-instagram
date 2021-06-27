//package by.instagram.storage.inmemory;
//
//import by.instagram.entity.Category;
//import by.instagram.storage.CategoryStorage;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class InMemoryCategoryStorage implements CategoryStorage {
//
//    private static final List<Category> categories = new ArrayList<>();
//    private static long incId = 1;
//
//    {
//        saveCategory(new Category(0, "animal"));
//        saveCategory(new Category(1, "car"));
//        saveCategory(new Category(2, "food"));
//    }
//
//    private void incrementId(Category category) {
//        category.setId(incId++);
//    }
//
//    public void saveCategory(Category category) {
//        incrementId(category);
//        categories.add(category);
//    }
//
//    @Override
//    public Category getById(long id) {
//        for (Category category : categories) {
//            if (category.getId() == id) {
//                return category;
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public List<Category> getAll() {
//        return categories;
//    }
//}

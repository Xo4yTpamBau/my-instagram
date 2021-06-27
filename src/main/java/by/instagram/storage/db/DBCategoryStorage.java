package by.instagram.storage.db;

import by.instagram.entity.Category;
import by.instagram.storage.CategoryStorage;
import by.instagram.web.listener.Listener;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBCategoryStorage implements CategoryStorage {

    private DataSource dataSource = Listener.dataSource;

    @Override
    public void saveCategory(Category category) {
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into categories values(default, ?)");
            preparedStatement.setString(1, category.getCategory());
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Category getCategoryById(long id) {
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from categories where id = ?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return new Category(resultSet.getLong(1), resultSet.getString(2));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return new Category();
    }

    @Override
    public List<Category> getAllCategories() {
        List<Category> all = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from categories");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                all.add(new Category(resultSet.getLong(1), resultSet.getString(2)));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return all;
    }

}

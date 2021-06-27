package by.instagram.storage.db;

import by.instagram.entity.Comment;
import by.instagram.storage.CommentStorage;
import by.instagram.web.listener.Listener;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBCommentStorage implements CommentStorage {

    private DataSource dataSource = Listener.dataSource;

    @Override
    public Comment saveComment(Comment comment) {
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into comments values(default , ?, ?) returning id");
            preparedStatement.setString(1, comment.getComment());
            preparedStatement.setLong(2, comment.getUser().getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return getCommentById(resultSet.getLong(1));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public void saveCommentToPost(long idComment, long idPost) {
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(("insert into post_comment values (?, ?)"));
            preparedStatement.setLong(1, idPost);
            preparedStatement.setLong(2, idComment);
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Comment> getAllComments() {
        List<Comment> all = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from comments");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                all.add(new Comment(resultSet.getLong(1), resultSet.getString(2),
                        null, null));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return all;
    }

    @Override
    public List<Comment> getAllCommentsByIdPost(long id) {
        List<Comment> all = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("select comment_id from post_comment where post_id = ? ");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                all.add(getCommentById(resultSet.getLong(1)));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return all;
    }

    @Override
    public Comment getCommentById(Long id) {
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from comments where id = ?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return new Comment(resultSet.getLong(1), resultSet.getString(2),
                    null, null);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteCommentById(long idComment) {
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from comments where id = ?");
            preparedStatement.setLong(1, idComment);
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}

package by.instagram.storage.db;

import by.instagram.entity.Like;
import by.instagram.entity.Post;
import by.instagram.entity.User;
import by.instagram.storage.LikeStorage;
import by.instagram.web.listener.Listener;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBLikeStorage implements LikeStorage {

    private DataSource dataSource = Listener.dataSource;

    @Override
    public Like saveLike(Like like) {
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into likes values (default, ? ) returning id");
            preparedStatement.setLong(1, like.getUser().getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return getLikeById(resultSet.getLong(1));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public void saveLikeToPost(long idLike, long idPost) {
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into like_post values (?, ?)");
            preparedStatement.setLong(1, idLike);
            preparedStatement.setLong(2, idPost);
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void saveLikeToComment(long idLike, long idComment) {
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into like_comment values (?, ?)");
            preparedStatement.setLong(1, idLike);
            preparedStatement.setLong(2, idComment);
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Like> getAllLikesByIdComment(long id) {
        List<Like> all = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("select like_id from like_comment where comment_id = ?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                all.add(getLikeById(resultSet.getLong(1)));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return all;
    }

    @Override
    public List<Like> getAllLikesByIdPost(long id) {
        List<Like> all = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("select like_id from like_post where post_id = ?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                all.add(getLikeById(resultSet.getLong(1)));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return all;
    }

    @Override
    public Like getLikeById(long id) {
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from likes where id = ?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return new Like(resultSet.getLong(1), null);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteLikeById(long idLike) {
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from likes where id = ?");
            preparedStatement.setLong(1, idLike);
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void deleteAllLikesByIdComment(long idComment){
        List<Like> likeByIdComment = getAllLikesByIdComment(idComment);
        for (Like like : likeByIdComment) {
            deleteLikeById(like.getId());
        }
    }

    public void deleteAllLikesByIdPost(long idPost){
        List<Like> likeByIdPost = getAllLikesByIdPost(idPost);
        for (Like like : likeByIdPost) {
            deleteLikeById(like.getId());
        }
    }

    @Override
    public boolean containsLikeByUser(Post post, User user) {
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("select count(*) from posts where where post_id = ? and  user_id = ?");
            preparedStatement.setLong(1, post.getId());
            preparedStatement.setLong(2, user.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            if (resultSet.getInt(1) > 0) {
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

}

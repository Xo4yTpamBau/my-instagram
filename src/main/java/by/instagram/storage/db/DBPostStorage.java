package by.instagram.storage.db;

import by.instagram.entity.Category;
import by.instagram.entity.Post;
import by.instagram.entity.User;
import by.instagram.storage.PostStorage;
import by.instagram.web.listener.Listener;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBPostStorage implements PostStorage {

    private DataSource dataSource = Listener.dataSource;

    private void saveUrls(long postId, List<String> urls) {
        try (Connection connection = dataSource.getConnection()) {
            for (String url : urls) {
                PreparedStatement preparedStatement1 = connection.prepareStatement("insert into urls values (default, ?, ?) ");
                preparedStatement1.setString(1, url);
                preparedStatement1.setLong(2, postId);
                preparedStatement1.execute();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void savePost(Post post) {
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into posts values (default , ?, ?, ?, ?, ?, ?, ?) returning id");
            preparedStatement.setString(1, post.getTitle());
            preparedStatement.setString(2, post.getDescription());
            preparedStatement.setLong(3, post.getUser().getId());
            preparedStatement.setLong(4, post.getViews());
            preparedStatement.setBoolean(5, false);
            preparedStatement.setLong(6, post.getCategory().getId());
            preparedStatement.setTimestamp(7, new Timestamp(post.getTime().getTime()));
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            long aLong = resultSet.getLong(1);
            List<String> urls = post.getUrls();
            saveUrls(aLong, urls);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Post> getAllPosts() {
        List<Post> all = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from posts ");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                all.add(new Post(resultSet.getLong(1), resultSet.getString(2),
                        resultSet.getString(3), null, urlsByPostId(resultSet.getLong(1)), null, null,
                        resultSet.getLong(5), resultSet.getTime(8),
                        resultSet.getBoolean(6), categoryById(resultSet.getLong(7))));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return all;
    }

    private List<String> urlsByPostId(long id) {
        List<String> all = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from urls where post_id = ? ");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                all.add(resultSet.getString(2));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return all;
    }


    private Category categoryById(long id) {
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from categories where id = ? ");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return new Category(resultSet.getLong(1), resultSet.getString(2));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public Post getPostById(long id) {
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from posts where id = ?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return new Post(resultSet.getLong(1), resultSet.getString(2),
                    resultSet.getString(3), null, urlsByPostId(resultSet.getLong(1)),
                    null, null, resultSet.getLong(5), resultSet.getTime(8),
                    resultSet.getBoolean(6), categoryById(resultSet.getLong(7)));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Post> getAllPostsByApprove() {
        List<Post> all = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from posts where approve = ?");
            preparedStatement.setBoolean(1, true);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                all.add(new Post(resultSet.getLong(1), resultSet.getString(2),
                        resultSet.getString(3), null, urlsByPostId(resultSet.getLong(1)), null, null,
                        resultSet.getLong(5), resultSet.getTime(8),
                        resultSet.getBoolean(6), categoryById(resultSet.getLong(7))));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return all;
    }

    @Override
    public List<Post> getAllPostsByNotApprove() {
        List<Post> all = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from posts where approve = ?");
            preparedStatement.setBoolean(1, false);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                all.add(new Post(resultSet.getLong(1), resultSet.getString(2),
                        resultSet.getString(3), null, urlsByPostId(resultSet.getLong(1)), null, null,
                        resultSet.getLong(5), resultSet.getTime(8),
                        resultSet.getBoolean(6), categoryById(resultSet.getLong(7))));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return all;
    }

    @Override
    public List<Post> getAllPostsByUser(User user) {
        List<Post> all = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from posts where user_id = ?");
            preparedStatement.setLong(1, user.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                all.add(new Post(resultSet.getLong(1), resultSet.getString(2),
                        resultSet.getString(3), null, urlsByPostId(resultSet.getLong(1)),
                        null, null, resultSet.getLong(5), resultSet.getTime(8),
                        resultSet.getBoolean(6), categoryById(resultSet.getLong(7))));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return all;
    }

    @Override
    public void approvePost(long id) {
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("update posts set approve = ? where id = ?");
            preparedStatement.setBoolean(1, true);
            preparedStatement.setLong(2, id);
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void deletePostById(long id) {
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from posts where id = ?");
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void views(long idPost, long views) {
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("update posts set views = ? where id = ?");
            preparedStatement.setLong(1, ++views);
            preparedStatement.setLong(2, idPost);
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


}

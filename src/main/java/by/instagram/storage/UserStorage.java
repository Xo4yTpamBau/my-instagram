package by.instagram.storage;

import by.instagram.entity.User;

import java.util.List;

public interface UserStorage {

     void registration(User user);

     User getUserByLogin(String login);

     User getUserById (long id);

     Long getIdUserByIdPost(long id);

     Long getIdUserByIdLike(long id);

     Long getIdUserByIdComment(long id);

     void updateNameUser(long id, String name);

     void updatePasswordUser(long id, String password);

     List<User> getAllUsers();

     boolean containsUserByName(String name);

     boolean containsUserByLogin(String login);




}

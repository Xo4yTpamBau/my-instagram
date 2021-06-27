package by.instagram.service;

import by.instagram.entity.User;
import by.instagram.storage.UserStorage;
import by.instagram.storage.db.DBUserStorage;

import java.util.List;

public class UserService {
    private final UserStorage userStorage = new DBUserStorage();


    public User registration(User user) {
        userStorage.registration(user);
        return user;
    }

    public User getUserByLogin(String login) {
        return userStorage.getUserByLogin(login);
    }

    public User getUserById(long id) {
        return userStorage.getUserById(id);
    }

    public Long getIdUserByIdPost(long id) {
        return userStorage.getIdUserByIdPost(id);
    }

    public Long getIdUserByIdLike(long id) {
        return userStorage.getIdUserByIdLike(id);
    }

    public Long getIdUserByIdComment(long id) {
        return userStorage.getIdUserByIdComment(id);
    }

    public void updateNameUser(long id, String name) {
        userStorage.updateNameUser(id, name);

    }

    public void updatePasswordUser(long id, String password) {
        userStorage.updatePasswordUser(id, password);
    }

    public List<User> getAllUser() {
        return userStorage.getAllUsers();
    }

    public boolean containsUserByName(String name) {
        return userStorage.containsUserByName(name);
    }

    public boolean containsUserByLogin(String login) {
        return userStorage.containsUserByLogin(login);
    }

}

//package by.instagram.storage.inmemory;
//
//import by.instagram.entity.Role;
//import by.instagram.entity.User;
//import by.instagram.storage.UserStorage;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class InMemoryUserStorage implements UserStorage {
//
//    private static final List<User> users = new ArrayList<>();
//    private static long incId = 1;
//
//    {
//        registration(new User(0, "Admin", "admin", "admin", new Role(0, "ADMIN")));
//        registration(new User(0, "User", "user", "user", new Role(1, "USER")));
//    }
//
//    private void incrementId(User user){
//        user.setId(incId++);
//    }
//
//    @Override
//    public void registration(User user) {
//        incrementId(user);
//        users.add(user);
//    }
//
//    @Override
//    public User getByLogin(String login) {
//        for (User user : users) {
//            if (user.getLogin().equals(login)) {
//                return user;
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public User getById(long id) {
//        for (User user : users) {
//            if (user.getId() == id) {
//                return user;
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public Long getIdUserByIdPost(long id) {
//        return null;
//    }
//
//    @Override
//    public Long getIdUserByIdLike(long id) {
//        return null;
//    }
//
//    @Override
//    public Long getIdUserByIdComment(long id) {
//        return null;
//    }
//
//    @Override
//    public void updateName(long id, String name) {
//        for (User user : users) {
//            if (user.getId() == id) {
//                user.setName(name);
//                break;
//            }
//        }
//
//    }
//
//    @Override
//    public void updatePassword(long id, String password) {
//        for (User user : users) {
//            if (user.getId() == id) {
//                user.setPassword(password);
//            }
//        }
//
//    }
//
//    @Override
//    public List<User> allUser() {
//        return new ArrayList<>(users);
//    }
//
//    @Override
//    public boolean containsByName(String name) {
//        for (User user : users) {
//            if (user.getName().equals(name)){
//                return true;
//            }
//        }
//        return false;
//    }
//
//    @Override
//    public boolean containsByLogin(String login) {
//        for (User user : users) {
//            if (user.getLogin().equals(login)){
//                return true;
//            }
//        }
//        return false;
//    }
//}

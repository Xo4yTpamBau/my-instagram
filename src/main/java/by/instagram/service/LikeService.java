package by.instagram.service;

import by.instagram.entity.Like;
import by.instagram.entity.Post;
import by.instagram.entity.User;
import by.instagram.storage.LikeStorage;

import by.instagram.storage.db.DBLikeStorage;


import java.util.List;

public class LikeService {
    private final LikeStorage likeStorage = new DBLikeStorage();
    private final UserService userService = new UserService();


    public void saveLikeToPost(long id, User user) {
        for (Like like : likeStorage.getAllLikesByIdPost(id)) {
            if (like.getUser().equals(user)) {
                likeStorage.deleteLikeById(like.getId());
                return;
            }
        }
        Like newLike = new Like();
        newLike.setUser(user);
        Like save = likeStorage.saveLike(newLike);
        likeStorage.saveLikeToPost(save.getId(), id);
    }

    public void saveLikeToComment(long id, User user) {
        for (Like like : likeStorage.getAllLikesByIdComment(id)) {
            if (like.getUser().equals(user)) {
                likeStorage.deleteLikeById(like.getId());
                return;
            }
        }
        Like newLike = new Like();
        newLike.setUser(user);
        Like save = likeStorage.saveLike(newLike);
        likeStorage.saveLikeToComment(save.getId(), id);
    }

    public List<Like> getAllLikesByIdComment(long id) {
        List<Like> likeByIdComment = likeStorage.getAllLikesByIdComment(id);
        for (Like like : likeByIdComment) {
            buildLike(like);
        }
        return likeByIdComment;
    }

    private void buildLike(Like like) {
        Long idUserByIdLike = userService.getIdUserByIdLike(like.getId());
        User byId = userService.getUserById(idUserByIdLike);
        like.setUser(byId);
    }

    public List<Like> getLikesByIdPost(long id) {
        List<Like> likeByIdPost = likeStorage.getAllLikesByIdPost(id);
        for (Like like : likeByIdPost) {
            buildLike(like);
        }
        return likeByIdPost;
    }

    public Like getLikeById(long id) {
        Like byId = likeStorage.getLikeById(id);
        buildLike(byId);
        return byId;
    }

    public void deleteLikeById(long id) {
        likeStorage.deleteLikeById(id);
    }

    public void deleteAllLikesByIdComment(long idComment) {
        likeStorage.deleteAllLikesByIdComment(idComment);
    }

    public void deleteAllLikesByIdPost(long idPost) {
        likeStorage.deleteAllLikesByIdPost(idPost);
    }

    public boolean containsLikeByUser(Post post, User user) {
        return likeStorage.containsLikeByUser(post, user);
    }
}

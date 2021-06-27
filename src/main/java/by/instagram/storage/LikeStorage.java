package by.instagram.storage;

import by.instagram.entity.Like;
import by.instagram.entity.Post;
import by.instagram.entity.User;

import java.util.List;

public interface LikeStorage {

    Like saveLike(Like like);

    void saveLikeToPost(long idLike, long idPost);

    void saveLikeToComment(long idLike, long idComment);

    List<Like> getAllLikesByIdComment(long idComment);

    List<Like> getAllLikesByIdPost(long idPost);

    Like getLikeById(long idLike);

    void deleteLikeById(long idLike);

    void deleteAllLikesByIdComment(long idComment);

    void deleteAllLikesByIdPost(long idPost);

    boolean containsLikeByUser(Post post, User user);

}

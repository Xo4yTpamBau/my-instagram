package by.instagram.service;

import by.instagram.entity.Comment;
import by.instagram.entity.Like;
import by.instagram.entity.User;
import by.instagram.storage.CommentStorage;
import by.instagram.storage.db.DBCommentStorage;

import java.util.List;

public class CommentService {
    private final CommentStorage commentStorage = new DBCommentStorage();
    private final UserService userService = new UserService();
    private final LikeService likeService = new LikeService();

    public void saveCommentToPost(long id, User user, String commentText) {
        Comment comment = new Comment();
        comment.setComment(commentText);
        comment.setUser(user);
        Comment save = commentStorage.saveComment(comment);
        commentStorage.saveCommentToPost(save.getId(), id);
    }

    public List<Comment> getAllComments() {
        List<Comment> all = commentStorage.getAllComments();
        for (Comment comment : all) {
            buildComment(comment);
        }
        return all;
    }

    private void buildComment(Comment comment) {
        Long idUserByIdComment = userService.getIdUserByIdComment(comment.getId());
        User byId = userService.getUserById(idUserByIdComment);
        comment.setUser(byId);
        List<Like> likeByIdComment = likeService.getAllLikesByIdComment(comment.getId());
        comment.setLikes(likeByIdComment);
    }

    public List<Comment> getAllCommentsByPost(long id) {
        List<Comment> all = commentStorage.getAllCommentsByIdPost(id);
        for (Comment comment : all) {
            buildComment(comment);
        }
        return all;
    }

    public Comment getCommentById(Long id) {
        Comment byId = commentStorage.getCommentById(id);
        buildComment(byId);
        return byId;

    }

    public void deleteCommentById(long idComment){
        likeService.deleteAllLikesByIdComment(idComment);
        commentStorage.deleteCommentById(idComment);
    }

    public void deleteAllCommentsByIdPost(long idPost){
        List<Comment> commentsByPost = getAllCommentsByPost(idPost);
        for (Comment comment : commentsByPost) {
            deleteCommentById(comment.getId());
        }
    }
}

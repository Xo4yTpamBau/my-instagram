package by.instagram.storage;

import by.instagram.entity.Comment;

import java.util.List;

public interface CommentStorage {

    Comment saveComment(Comment comment);

    void saveCommentToPost(long idComment, long idPost);

    List<Comment> getAllComments();

    List<Comment> getAllCommentsByIdPost(long idPost);

    Comment getCommentById(Long idComment);

    void deleteCommentById(long idComment);


}

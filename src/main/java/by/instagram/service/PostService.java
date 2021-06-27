package by.instagram.service;

import by.instagram.entity.Comment;
import by.instagram.entity.Like;
import by.instagram.entity.Post;
import by.instagram.entity.User;
import by.instagram.storage.PostStorage;
import by.instagram.storage.db.DBPostStorage;


import java.util.ArrayList;
import java.util.List;

public class PostService {
    private final PostStorage postStorage = new DBPostStorage();
    private final LikeService likeService = new LikeService();
    private final CommentService commentService = new CommentService();
    private final UserService userService = new UserService();

    public void savePost(Post post) {
        postStorage.savePost(post);
    }

    public List<Post> getAllPosts() {
        List<Post> all = postStorage.getAllPosts();
        for (Post post : all) {
            buildPost(post);
        }
        return all;
    }

    public List<Post> searchPost(String query) {
        List<Post> allByApprove = postStorage.getAllPostsByApprove();
        List<Post> all = new ArrayList<>();
        for (Post post : allByApprove) {
            String s = post.getTitle().toLowerCase();
            String s1 = query.toLowerCase();
            if (s.contains(s1)) {
                all.add(post);
            }
        }
        return all;
    }

    public Post getPostById(long id) {
        Post post = postStorage.getPostById(id);
        buildPost(post);
        return post;
    }

    public List<Post> getAllPostsByApprove() {
        List<Post> allByApprove = postStorage.getAllPostsByApprove();
        for (Post post : allByApprove) {
            buildPost(post);
        }
        return allByApprove;
    }

    public List<Post> getAllPostsByNotApprove() {
        List<Post> allByNotApprove = postStorage.getAllPostsByNotApprove();
        for (Post post : allByNotApprove) {
            buildPost(post);
        }
        return allByNotApprove;
    }

    public void approvePost(long idPost) {
        postStorage.approvePost(idPost);
    }


    public void deletePostById(long idPost) {
        commentService.deleteAllCommentsByIdPost(idPost);
        likeService.deleteAllLikesByIdPost(idPost);
        postStorage.deletePostById(idPost);
    }

    public List<Post> getAllPostsByUser(User user) {
        List<Post> allByUser = postStorage.getAllPostsByUser(user);
        for (Post post : allByUser) {
            buildPost(post);
        }
        return allByUser;
    }

    private void buildPost(Post post) {
        Long idUserByIdPost = userService.getIdUserByIdPost(post.getId());
        User byId = userService.getUserById(idUserByIdPost);
        post.setUser(byId);
        List<Like> likeByIdPost = likeService.getLikesByIdPost(post.getId());
        post.setLikes(likeByIdPost);
        List<Comment> commentsByPost = commentService.getAllCommentsByPost(post.getId());
        post.setComments(commentsByPost);
    }

    public void views (long idPost, long views){
        postStorage.views(idPost,views);
    }
}

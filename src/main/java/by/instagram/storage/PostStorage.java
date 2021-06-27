package by.instagram.storage;

import by.instagram.entity.Post;
import by.instagram.entity.User;

import java.util.List;

public interface PostStorage {
    
    void savePost(Post post);

    List<Post> getAllPosts();

    Post getPostById(long idPost);

    List<Post> getAllPostsByApprove();

    List<Post> getAllPostsByNotApprove();

    List<Post> getAllPostsByUser(User user);

    void approvePost(long idPost);

    void deletePostById(long idPost);

    void views(long IdPost, long views);

}

package by.instagram.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    private long id;
    private String title;
    private String description;
    private User user;
    private List<String> urls;
    private List<Comment> comments;
    private List<Like> likes;
    private Long views;
    private Date time;
    private boolean approve;
    private Category category;

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", views=" + views +
                ", time=" + time +
                '}';
    }
}

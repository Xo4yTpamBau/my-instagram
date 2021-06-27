package by.instagram.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    private long id;
    private String comment;
    private User user;
    private List<Like> likes;

}

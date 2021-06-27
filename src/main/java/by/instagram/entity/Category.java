package by.instagram.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Category {

    private long id;
    private String category;
    private boolean isEmpty = true;

    public Category(long id, String category) {
        this.id = id;
        this.category = category;
        this.isEmpty = false;
    }

    public boolean isEmpty(){
        return isEmpty;
    }

}

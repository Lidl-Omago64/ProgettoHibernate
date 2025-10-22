package org.example.model.tag;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class Tag {
    private int id;
    private String title;

}

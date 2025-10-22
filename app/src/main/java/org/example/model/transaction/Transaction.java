package org.example.model.transaction;


import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.example.model.tag.Tag;

import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter

public abstract class Transaction {
    private int id;
    private double amount;
    private String description;
    private Date date;
    private Set<Tag> tag;


}

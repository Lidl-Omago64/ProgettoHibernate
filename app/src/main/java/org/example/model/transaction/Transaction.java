package org.example.model.transaction;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.model.tag.Tag;

import java.util.Date;
import java.util.Set;


@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
public abstract class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Double amount;
    private String description;
    private Date date;
    @ManyToMany
    @JoinTable(
            name = "transaction_tag",
            joinColumns = @JoinColumn(name = "transaction_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private Set<Tag> tag;

}

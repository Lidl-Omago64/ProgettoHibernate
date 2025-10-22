package org.example.model.transaction;


import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class DeadlineTransaction extends Transaction {
    private Date deadline;
}

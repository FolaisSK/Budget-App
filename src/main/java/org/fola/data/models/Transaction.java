package org.fola.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
@Data
public class Transaction {
    @Id
    private String id;
    private String title;
    private double amount;
    private TransactionType type;
}

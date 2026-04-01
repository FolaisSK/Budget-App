package org.fola.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Expense {
    @Id
    private String id;
    private ExpenseType type;
    private String description;
    private double amount;

}

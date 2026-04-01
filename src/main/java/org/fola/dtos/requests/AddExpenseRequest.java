package org.fola.dtos.requests;

import lombok.Data;
import org.fola.data.models.ExpenseType;

@Data
public class AddExpenseRequest {
    private String budgetTitle;
    private ExpenseType type;
    private String description;
    private double amount;
}

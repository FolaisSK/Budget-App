package org.fola.dtos.responses;

import lombok.Data;

@Data
public class AddExpenseResponse {
    private String budgetTitle;
    private String type;
    private String description;
    private double amount;
}

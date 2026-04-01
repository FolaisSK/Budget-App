package org.fola.dtos.requests;

import lombok.Data;

@Data
public class AddIncomeRequest {
    private String budgetTitle;
    private String source;
    private double amount;
}

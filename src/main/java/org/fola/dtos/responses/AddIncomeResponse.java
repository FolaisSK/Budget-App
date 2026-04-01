package org.fola.dtos.responses;

import lombok.Data;

@Data
public class AddIncomeResponse {
    private String budgetTitle;
    private String source;
    private double amount;
}

package org.fola.utils;

import org.fola.data.models.Budget;
import org.fola.dtos.requests.CreateBudgetRequest;
import org.fola.dtos.responses.CreateBudgetResponse;

public class Mapper {
    public static Budget map(CreateBudgetRequest request) {
        Budget budget = new Budget();
        budget.setTitle(request.getTitle());
        budget.setStartDate(request.getStartDate());
        budget.setEndDate(request.getEndDate());
        return budget;
    }

    public static CreateBudgetResponse map(Budget budget){

    }
}

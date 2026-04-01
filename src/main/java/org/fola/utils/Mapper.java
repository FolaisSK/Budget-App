package org.fola.utils;

import org.fola.data.models.Budget;
import org.fola.data.models.Expense;
import org.fola.data.models.Income;
import org.fola.dtos.requests.AddExpenseRequest;
import org.fola.dtos.requests.AddIncomeRequest;
import org.fola.dtos.requests.CreateBudgetRequest;
import org.fola.dtos.responses.AddIncomeResponse;
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
        CreateBudgetResponse response = new CreateBudgetResponse();
        response.setId(budget.getId());
        response.setTitle(budget.getTitle());
        response.setStartDate(budget.getStartDate());
        response.setEndDate(budget.getEndDate());
        response.setInflows(budget.getInflows());
        response.setOutflows(budget.getOutflows());
        response.setCreatedAt(budget.getCreatedAt());
        return response;
    }

    public static Income map(AddIncomeRequest request){
        Income income = new Income();
        income.setSource(request.getSource());
        income.setAmount(request.getAmount());
        return income;
    }

    public static Expense map(AddExpenseRequest request){
        Expense expense = new Expense();
        expense.setType(request.getType());
        expense.setDescription(request.getDescription());
        expense.setAmount(request.getAmount());
        return expense;
    }
}

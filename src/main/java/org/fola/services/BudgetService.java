package org.fola.services;

import org.fola.data.models.Budget;
import org.fola.data.models.Expense;
import org.fola.data.models.Income;
import org.fola.data.repositories.BudgetRepository;
import org.fola.dtos.requests.AddExpenseRequest;
import org.fola.dtos.requests.AddIncomeRequest;
import org.fola.dtos.requests.CreateBudgetRequest;
import org.fola.dtos.responses.AddExpenseResponse;
import org.fola.dtos.responses.AddIncomeResponse;
import org.fola.dtos.responses.CreateBudgetResponse;
import org.fola.exceptions.BudgetDoesNotExistException;
import org.fola.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BudgetService {
    @Autowired
    BudgetRepository budgetRepository;

    public CreateBudgetResponse createBudget (CreateBudgetRequest request){
        Budget budget = Mapper.map(request);
        budgetRepository.save(budget);
        return Mapper.map(budget);
    }

    public Budget getBudget (String title){
        Budget budget = budgetRepository.findByTitle(title.trim())
                        .orElseThrow(()-> new BudgetDoesNotExistException("Budget does not exist!"));
        return budget;
    }

    public List<CreateBudgetResponse> getAllBudgets(){
        return budgetRepository.findAll().stream().map(budget -> Mapper.map(budget)).toList();
    }

    public AddIncomeResponse addIncome(AddIncomeRequest request){
        AddIncomeResponse response = new AddIncomeResponse();
        Income income = Mapper.map(request);
        response.setBudgetTitle(request.getBudgetTitle().trim());
        response.setSource(income.getSource());
        response.setAmount(income.getAmount());

        Budget budget = budgetRepository.findByTitle(request.getBudgetTitle().trim())
                .orElseThrow(()-> new BudgetDoesNotExistException("Budget does not exist!"));
        List<Income> inflows = budget.getInflows();
        inflows.add(income);
        budget.setInflows(inflows);
        budgetRepository.save(budget);

        return response;
    }

    public AddExpenseResponse addExpense(AddExpenseRequest request){
        AddExpenseResponse response = new AddExpenseResponse();
        Expense expense = Mapper.map(request);
        response.setBudgetTitle(request.getBudgetTitle());
        response.setDescription(expense.getDescription());
        response.setType(String.valueOf(expense.getType()));
        response.setAmount(expense.getAmount());

        Budget budget = budgetRepository.findByTitle(request.getBudgetTitle().trim())
                .orElseThrow(()-> new BudgetDoesNotExistException("Budget does not exist!"));
        List<Expense> outflows = budget.getOutflows();
        outflows.add(expense);
        budget.setOutflows(outflows);
        budgetRepository.save(budget);

        return response;
    }

    public double calculateTotalIncome(String title){
        Budget budget = budgetRepository.findByTitle(title.trim())
                .orElseThrow(()-> new BudgetDoesNotExistException("Budget does not exist!"));
        List<Income> inflows = budget.getInflows();

        double total = 0;
        for(Income income: inflows){
            total += income.getAmount();
        }

        return total;
    }

    public double calculateTotalExpense(String title){
        Budget budget = budgetRepository.findByTitle(title.trim())
                .orElseThrow(()-> new BudgetDoesNotExistException("Budget does not exist!"));
        List<Expense> outflows = budget.getOutflows();

        double total = 0;
        for(Expense expense: outflows) total += expense.getAmount();

        return total;
    }

    public double calculateNetIncome(String title){
        return calculateTotalIncome(title) - calculateTotalExpense(title);
    }
}

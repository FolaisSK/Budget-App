package org.fola.services;

import org.fola.data.models.Budget;
import org.fola.data.repositories.BudgetRepository;
import org.fola.dtos.requests.CreateBudgetRequest;
import org.fola.dtos.responses.CreateBudgetResponse;
import org.fola.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BudgetService {
    @Autowired
    BudgetRepository budgetRepository;

    public CreateBudgetResponse createBudget (CreateBudgetRequest request){
        Budget budget = Mapper.map(request);
        budgetRepository.save(budget);
        return Mapper.map(budget);
    }
}

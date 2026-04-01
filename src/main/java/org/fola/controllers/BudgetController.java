package org.fola.controllers;

import org.fola.dtos.requests.CreateBudgetRequest;
import org.fola.dtos.responses.ApiResponse;
import org.fola.services.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;

@RestController
@RequestMapping("/expense-tracker/v1")
public class BudgetController {
    @Autowired
    BudgetService budgetService;

    @PostMapping("/create-budget")
    public ApiResponse createBudget(@RequestBody CreateBudgetRequest request){
        try {
            return new ApiResponse(true, HttpStatus.OK.name(), budgetService.createBudget(request));
        } catch (Exception e) {
            return new ApiResponse(false, HttpStatus.BAD_REQUEST.name(), e.getMessage());
        }
    }

    @GetMapping("/view-budget/{budgetTitle}")
    public ApiResponse viewBudget(@PathVariable("budgetTitle") String budgetTitle){
        try{
            return new ApiResponse(true, HttpStatus.OK.name(), budgetService.getBudget(budgetTitle));
        } catch (Exception e) {
            return new ApiResponse(false, HttpStatus.BAD_REQUEST.name(), e.getMessage());
        }
    }

    @GetMapping("/all-bugdets")
    public ApiResponse viewAllBudgets(){
        try {
            return new ApiResponse(true, HttpStatus.OK.name(), budgetService.getAllBudgets());
        } catch (Exception e) {
            return new ApiResponse(false, HttpStatus.BAD_REQUEST.name(), e.getMessage());
        }
    }
}

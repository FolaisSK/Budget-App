package org.fola.controllers;

import org.fola.dtos.requests.AddExpenseRequest;
import org.fola.dtos.requests.AddIncomeRequest;
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

    @PostMapping("/add-income")
    public ApiResponse addIncome(@RequestBody AddIncomeRequest request){
        try{
            return new ApiResponse(true, HttpStatus.OK.name(), budgetService.addIncome(request));
        } catch (Exception e) {
            return new ApiResponse(false, HttpStatus.BAD_REQUEST.name(), e.getMessage());
        }
    }

    @PostMapping("/add-expense")
    public ApiResponse addExpense(@RequestBody AddExpenseRequest request){
        try{
            return new ApiResponse(true, HttpStatus.OK.name(), budgetService.addExpense(request));
        } catch (Exception e) {
            return new ApiResponse(false, HttpStatus.BAD_REQUEST.name(), e.getMessage());
        }
    }

    @GetMapping("/total-income/{budgetTitle}")
    public ApiResponse viewTotalIncome(@PathVariable("budgetTitle") String budgetTitle){
        try{
            return new ApiResponse(true, HttpStatus.OK.name(), budgetService.calculateTotalIncome(budgetTitle));
        } catch (Exception e) {
            return new ApiResponse(false, HttpStatus.BAD_REQUEST.name(), e.getMessage());
        }
    }

    @GetMapping("/total-expense/{budgetTitle}")
    public ApiResponse viewTotalExpense(@PathVariable("budgetTitle") String budgetTitle){
        try{
            return new ApiResponse(true, HttpStatus.OK.name(), budgetService.calculateTotalExpense(budgetTitle));
        } catch (Exception e) {
            return new ApiResponse(false, HttpStatus.BAD_REQUEST.name(), e.getMessage());
        }
    }

    @GetMapping("/net-income/{budgetTitle}")
    public ApiResponse viewNetIncome(@PathVariable("budgetTitle") String budgetTitle){
        try{
            return new ApiResponse(true, HttpStatus.OK.name(), budgetService.calculateNetIncome(budgetTitle));
        } catch (Exception e) {
            return new ApiResponse(false, HttpStatus.BAD_REQUEST.name(), e.getMessage());
        }
    }
}

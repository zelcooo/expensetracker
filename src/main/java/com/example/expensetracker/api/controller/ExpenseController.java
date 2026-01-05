package com.example.expensetracker.api.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;

import com.example.expensetracker.api.dtos.CreateExpenseDto;
import com.example.expensetracker.api.dtos.EditExpenseDto;
import com.example.expensetracker.api.dtos.ExpenseResponseDto;
import com.example.expensetracker.api.model.Expense;
import com.example.expensetracker.service.ExpenseService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {

    private final ExpenseService service;

    public ExpenseController(ExpenseService service) {
        this.service = service;
    }

    @GetMapping
    public List<ExpenseResponseDto> getAll() {
        return service.getAllExpense();
    }

    @GetMapping("/{id}")
    public ExpenseResponseDto getById(@PathVariable long id) {
        return service.findExpenseID(id);
    }

    @PutMapping("/{id}")
    public void edit(@Valid @RequestBody EditExpenseDto expense, @PathVariable long id) {
        service.editExpense(id, expense);
    }

    @PostMapping
    public ExpenseResponseDto create(@Valid @RequestBody CreateExpenseDto expense) {
        return service.createExpense(expense);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        service.deleteExpense(id);
    }

}

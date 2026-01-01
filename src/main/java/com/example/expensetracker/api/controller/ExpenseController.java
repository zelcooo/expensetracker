package com.example.expensetracker.api.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.example.expensetracker.api.model.Expense;
import com.example.expensetracker.service.ExpenseService;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {

    private final ExpenseService service;

    public ExpenseController(ExpenseService service) {
        this.service = service;
    }

    @GetMapping
    public List<Expense> getAll() {
        return service.getAllExpense();
    }

    @GetMapping("/{id}")
    public Expense getById(@PathVariable long id) {
        return service.findExpenseID(id).orElseThrow(() -> new RuntimeException("ID not found"));
    }

    @PutMapping("/{id}")
    public void edit(@RequestBody Expense expense, @PathVariable long id) {
        service.editExpense(id, expense);
    }

    @PostMapping
    public Expense create(@RequestBody Expense expense) {
        return service.createExpense(expense);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        service.deleteExpense(id);
    }

}

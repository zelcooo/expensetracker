package com.example.expensetracker.service;
import java.util.List;
import java.util.Optional;

import com.example.expensetracker.api.model.Expense;
import org.springframework.stereotype.Service;

import com.example.expensetracker.api.model.ExpenseRepository;

@Service
public class ExpenseService {

    private final ExpenseRepository repository;

    public ExpenseService(ExpenseRepository repository){
        this.repository = repository;
    }

    public List<Expense> getAllExpense(){
        return repository.findAll();
    }

    public Optional<Expense> findExpenseID(long id){
        return repository.findById(id);
    }

    public Expense createExpense(Expense expense){
        return repository.save(expense);
    }

}

package com.example.expensetracker.service;

import java.util.List;
import java.util.Optional;

import com.example.expensetracker.Exceptions.NotFoundException;
import com.example.expensetracker.api.model.Expense;
import org.springframework.stereotype.Service;

import com.example.expensetracker.api.model.ExpenseRepository;

@Service
public class ExpenseService {

    private final ExpenseRepository repository;

    // This is our simple dependency injection constructor. 
    public ExpenseService(ExpenseRepository repository) {
        this.repository = repository;
    }

    // This function is used to fetch all of the expenses from the database. 
    public List<Expense> getAllExpense() {
        return repository.findAll();
    }

    // This is our function that finds an expense by its ID. It is a Optional<Expense>, so if our
    // Expense is not found, it simply returns a empty optional. 
    public Optional<Expense> findExpenseID(long id) {
        return repository.findById(id);
    }

    // This function is to delete an Expense out of our repository. It takes in a id, and finds
    // the reference to the id and attempts to delete it. If it does not delete succesfully, 
    // that means that the id is not in the database and a exception is thrown. 
    public void deleteExpense(long id) {

        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new NotFoundException("This expense was not found");
        }

    }

    public Expense createExpense(Expense expense) {
        return repository.save(expense);
    }

}

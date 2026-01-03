package com.example.expensetracker.service;

import java.util.List;
import java.util.Optional;

import com.example.expensetracker.Exceptions.NotFoundException;
import com.example.expensetracker.api.dtos.CreateExpenseDto;
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

    // This method is used to edit Expenses, it takes in a id and checks if the expense id exists.
    // If the id exists, we create a Expense object which points to the expense in the repository
    // then we return the object which was updated by the editExpense method. If they are not found
    // we throw a NotFoundException. 
    public Expense editExpense(long id, Expense expense) {

        if (repository.existsById(id)) {
            Expense editedExpense = repository.getReferenceById(id);
            editedExpense.editExpense(expense);
            return repository.save(editedExpense);
        } else {
            throw new NotFoundException("This expense was not found");
        }

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

    // This is a simple createExpense 
    public Expense createExpense(CreateExpenseDto dto) {
        Expense expense = new Expense(dto.getTitle(),
                dto.getAmountSpent(),
                dto.getCategory(),
                dto.getDate());

        return repository.save(expense);
    }

}

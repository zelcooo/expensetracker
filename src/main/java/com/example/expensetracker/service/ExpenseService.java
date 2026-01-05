package com.example.expensetracker.service;

import java.util.List;
import java.util.Optional;

import com.example.expensetracker.Exceptions.NotFoundException;
import com.example.expensetracker.api.dtos.CreateExpenseDto;
import com.example.expensetracker.api.dtos.EditExpenseDto;
import com.example.expensetracker.api.dtos.ExpenseResponseDto;
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
    public List<ExpenseResponseDto> getAllExpense() {

        return repository.findAll().stream().map(this::mapToResponseDto).toList();

    }

    // This is our function that finds an expense by its ID. It is a Optional<Expense>, so if our
    // Expense is not found, it simply returns a empty optional. 
    public ExpenseResponseDto findExpenseID(long id) {

        return repository.findById(id).map(this::mapToResponseDto)
                .orElseThrow(() -> new NotFoundException("Expense was not found"));

    }

    // This method is used to edit Expenses, it takes in a id and checks if the expense id exists.
    // If the id exists, we create a Expense object which points to the expense in the repository
    // then we return the object which was updated by the editExpense method. If they are not found
    // we throw a NotFoundException. 
    public ExpenseResponseDto editExpense(long id, EditExpenseDto expense) {

        if (repository.existsById(id)) {

            Expense editedExpense = repository.getReferenceById(id);

            // We are editing our expense that we searched for by ID and updating it with validated
            // fields enforced by the EditExpenseDto object. 
            editedExpense.setTitle(expense.getTitle());
            editedExpense.setAmountSpent(expense.getAmountSpent());
            editedExpense.setCategory(expense.getCategory());
            editedExpense.setDate(expense.getDate());

            // we then save it to our repository. 
            repository.save(editedExpense);
            // then return the responseDto
            return mapToResponseDto(editedExpense);
        } else {

            // If our expense was not found we throw a NotFoundException. 
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

    // This is a simple createExpense function, it uses a CreateExpenseDto Object to enforce valid
    // fields and then we create a Expense object out of the dto object. 
    public ExpenseResponseDto createExpense(CreateExpenseDto dto) {

        Expense expense = new Expense(dto.getTitle(),
                dto.getAmountSpent(),
                dto.getCategory(),
                dto.getDate());

        // we then save the expense to the repository.
        repository.save(expense);
        // after we have saved it to the expenseRepository we return the expenseResponseDto
        return mapToResponseDto(expense);
    }

    public ExpenseResponseDto mapToResponseDto(Expense expense) {
        return new ExpenseResponseDto(expense.getId(), expense.getTitle(), expense.getAmountSpent(),
                expense.getCategory(), expense.getDate());
    }

}

package com.example.expensetracker.api.dtos;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class EditExpenseDto {

    // @NotBlank is especially important here because we must know the item that was bought for
    // the expense tracker.
    @NotBlank(message = "Item can not be blank")
    private String title;

    // The @Postive annotation is crucuial because it makes sure that users can not enter in 
    // negative amounts of money spent on a object.
    @Positive(message = "Amount spent can not be negative")
    private double amountSpent;

    // the @NotBlank annotation is important because it enforces that we have a category for our
    // EditExpenseDto object
    @NotBlank(message = "Item must have a category")
    private String category;

    // the @NotNull annotation forces our date to be valid and entered in properly
    @NotNull(message = "Must have a date")
    private LocalDate date;

    // getter for the title
    public String getTitle() {
        return title;
    }

    // getter for amount spent
    public double getAmountSpent() {
        return amountSpent;
    }

    // getter for category
    public String getCategory() {
        return category;
    }

    // getter for the date
    public LocalDate getDate() {
        return date;
    }

}

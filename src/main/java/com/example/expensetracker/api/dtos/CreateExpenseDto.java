package com.example.expensetracker.api.dtos;

import java.time.LocalDate;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class CreateExpenseDto {

    @NotBlank(message = "Item can not be blank")
    private String title;

    @Positive(message = "Amount spent can not be negative")
    private double amountSpent;

    @NotBlank(message = "Item must have a category")
    private String category;

    @NotNull(message = "Must have a date")
    private LocalDate date;

    public double getAmountSpent() {
        return amountSpent;
    }

    public String getCategory() {
        return category;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }

}

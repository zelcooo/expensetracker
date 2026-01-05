package com.example.expensetracker.api.dtos;

import java.time.LocalDate;

import com.example.expensetracker.api.model.Expense;

public class ExpenseResponseDto {

    // same fields as our expense Entity.
    private long id;
    private String title;
    private double amountSpent;
    private String category;
    private LocalDate date;

    // basic constructor for the ExpenseReponseDto object.
    public ExpenseResponseDto(long id, String title, double amountSpent, String category, LocalDate date) {
        this.id = id;
        this.title = title;
        this.amountSpent = amountSpent;
        this.category = category;
        this.date = date;
    }

    // getters are only need since this is a response DTO
    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public double getAmountSpent() {
        return amountSpent;
    }

    public String getCategory() {
        return category;
    }

    public LocalDate getDate() {
        return date;
    }

}

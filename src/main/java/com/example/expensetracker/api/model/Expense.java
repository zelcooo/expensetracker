package com.example.expensetracker.api.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "expenses")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private double amountSpent;
    private String category;
    private LocalDate date;

    // This is the constructor for the Expense model, it has an id associated with every expense, 
    // title, amount spennt, category (so like food, tech, medical, etc.... It also has a date 
    // which is useful for cases when you want to know when you bought that expense. )
    public Expense(String title, double amountSpent, String category, LocalDate date) {
        this.title = title;
        this.amountSpent = amountSpent;
        this.category = category;
        this.date = date;
    }

    public void editExpense(Expense e) {
        title = e.title;
        amountSpent = e.amountSpent;
        category = e.category;
        date = e.date;
    }

    protected Expense() {
    }

    //  getter for id
    public long getId() {
        return id;
    }

    // getter for the title
    public String getTitle() {
        return title;
    }

    // getter for the amount spent
    public double getAmountSpent() {
        return amountSpent;
    }

    // getter for the category
    public String getCategory() {
        return category;
    }

    // getter for the date
    public LocalDate getDate() {
        return date;
    }

    // setter for title
    public void setTitle(String title) {
        this.title = title;
    }

    // setter for amount spent
    public void setAmountSpent(double amountSpent) {
        this.amountSpent = amountSpent;
    }

    // setter for the category
    public void setCategory(String category) {
        this.category = category;
    }

    // setter for the date. 
    public void setDate(LocalDate date) {
        this.date = date;
    }

}

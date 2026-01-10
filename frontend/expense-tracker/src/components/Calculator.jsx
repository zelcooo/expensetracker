import './Calculator.css'
import { useState } from 'react'

export default function Calculator({onAddExpense}){



    const[title, setTitle] = useState("");
    const[amount, setAmount] = useState("");
    const[category, setCategory] = useState("");
    const[date, setDate] = useState("");

    function resetForm(){
        setTitle("");
        setAmount("");
        setCategory("");
        setDate("");
    }

    const handleSubmit = async (e) => {
        e.preventDefault();

        const expense = {
            title,amountSpent : Number(amount),category,date,
        };
    

    const res = await fetch("http://localhost:8080/expenses", {
        method: "POST",
        headers:{"Content-Type" : "application/json" },
        body: JSON.stringify(expense),
    });

    const savedExpense = await res.json();

    onAddExpense(savedExpense);

    resetForm();
    }

    


    return(
        
            <form className="expense-form" onSubmit={handleSubmit}>

                <label>
                    Title
                    <input type="text" value={title} onChange = {(e) => setTitle(e.target.value)}
                    placeholder="Enter in title of expense"/>

                </label>

                <label>
                    Amount
                    <input type="number" placeholder='$0.00' value = {amount} 
                    onChange = {(e) => setAmount(e.target.value)} />
                </label>

                <label >
                    Category
                    <select value={category} onChange={(e) => setCategory(e.target.value)}>
                        <option value="">Select category</option>
                        <option value="Food">Food</option>
                        <option value="Rent">Rent</option>
                        <option value="Transport">Transport</option>
                        <option value="Other">Other</option>
                    </select>
                </label>

                <label >
                    Date
                    <input type="date" value={date} onChange={(e) => setDate(e.target.value)}/>
                </label>

                <button type="submit">Add Expense</button>



            </form>

    )
}
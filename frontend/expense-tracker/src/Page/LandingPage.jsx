import './LandingPage.css'
import Card from '../components/Card'
import Calculator from '../components/Calculator'
import ExpenseList from '../components/ExpenseList'
import { useEffect, useState } from 'react'

export default function LandingPage() {

    const[expense, setExpenses] = useState([]);

    const addExpense = (newExpense) => {
        setExpenses((prev) => [newExpense, ...prev]);
    }

    useEffect(() => {
        fetch("http://localhost:8080/api/expenses")
        .then(res => res.json())
        .then(data => setExpenses(data));
    }, [])


    return (
        <div className="dashboard">

            <Card>
                <h2>Add Expense</h2>
                <Calculator onAddExpense={addExpense}/>
            </Card>

            <Card>
                <h2>Recent Expenses</h2>
                <ExpenseList expenses ={expense}/>
            </Card>
        </div>
    )
}
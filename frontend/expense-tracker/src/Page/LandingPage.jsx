import './LandingPage.css'
import Card from '../components/Card'
import Calculator from '../components/Calculator'
import ExpenseList from '../components/ExpenseList'
import { useEffect, useState} from 'react'

export default function LandingPage() {

    const[expenses, setExpenses] = useState([]);

    const addExpense = (newExpense) => {
        setExpenses((prev) => [newExpense, ...prev]);
    }

    const deleteExpense = async(id) => {
        await fetch(`http://localhost:8080/expenses/${id}`,{
            method: "DELETE",
        });
        setExpenses(prev=>prev.filter(e => e.id != id))
    }

    const total = expenses.reduce(
     (sum, exp) => sum + exp.amountSpent,
    0
    );


    useEffect(() => {
        fetch("http://localhost:8080/expenses")
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
                <div className="total-spent">
                    <span className="total-label">Total spent</span>
                    <h3 className="total-amount">
                        ${total.toLocaleString("en-US", { minimumFractionDigits: 2,})}
                    </h3>
                </div>
                
                <ExpenseList expenses ={expenses}
                onDelete={deleteExpense}/>
            </Card>
        </div>
    )
}
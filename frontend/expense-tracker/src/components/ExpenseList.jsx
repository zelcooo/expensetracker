import './ExpenseList.css'




export default function ExpenseList({expenses, onDelete}){
    return(
        <div className="expense-list">

            {expenses.map(exp => (
                <div key={exp.id} className="expense-item">
                <span className="expense-title">{exp.title}</span>
                <span className="expese-amount">${exp.amountSpent}</span>
                <button onClick={() => onDelete(exp.id)} className="delete-btn">×</button>
                </div>
            ))}

        </div>
    )
}
import './ExpenseList.css'

export default function ExpenseList({expense}){
    return(
        <div className="expense-list">

            {expense.map(exp => (
                <div key={exp.id} className="expense-item">
                <span>{exp.title}</span>
                <span>{exp.amount}</span>
                </div>
            ))}

        </div>
    )
}
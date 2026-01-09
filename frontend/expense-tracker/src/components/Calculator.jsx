import './Calculator.css'

export default function Calculator(){
    return(
        <>
            <form className="expense-form">
                <label >
                    Amount
                    <input type="number" placeholder='$0.00'/>
                </label>

                <label >
                    Category
                    <select>
                        <option>Food</option>
                        <option>Rent</option>
                        <option>Transport</option>
                        <option>Other</option>
                    </select>
                </label>

                <label >
                    Date
                    <input type="date"/>
                </label>

                 <label >
                    Note
                    <input type="text" placeholder="Optional"/>
                </label>

                <button type="button">Add Expense</button>



            </form>




        </>
    )
}
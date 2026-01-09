import './LandingPage.css'
import Card from '../components/Card'
import Calculator from '../components/Calculator'

export default function LandingPage() {
    return (
        <div className="dashboard">

            <Card>
                <h2>Add Expense</h2>
                <Calculator/>
            </Card>

            <Card>
                <h2>Recent Expense</h2>
            </Card>
        </div>
    )
}
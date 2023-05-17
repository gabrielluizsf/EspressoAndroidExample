import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onButtonClick(view: View) {
        when (view.id) {
            R.id.button0 -> numberPressed("0")
            R.id.button1 -> numberPressed("1")
            R.id.button2 -> numberPressed("2")
            R.id.button3 -> numberPressed("3")
            R.id.button4 -> numberPressed("4")
            R.id.button5 -> numberPressed("5")
            R.id.button6 -> numberPressed("6")
            R.id.button7 -> numberPressed("7")
            R.id.button8 -> numberPressed("8")
            R.id.button9 -> numberPressed("9")
            R.id.buttonPlus -> operatorPressed("+")
            R.id.buttonMinus -> operatorPressed("-")
            R.id.buttonMultiply -> operatorPressed("*")
            R.id.buttonDivide -> operatorPressed("/")
            R.id.buttonClear -> clearPressed()
            R.id.buttonEquals -> equalsPressed()
        }
    }

    private fun numberPressed(number: String) {
        val currentValue = resultTextView.text.toString()
        resultTextView.text = currentValue + number
    }

    private fun operatorPressed(operator: String) {
        val currentValue = resultTextView.text.toString()
        if (currentValue.isNotEmpty()) {
            resultTextView.text = currentValue + operator
        }
    }

    private fun clearPressed() {
        resultTextView.text = ""
    }

    private fun equalsPressed() {
        val expression = resultTextView.text.toString()
        if (expression.isNotEmpty()) {
            try {
                val result = evaluateExpression(expression)
                resultTextView.text = result.toString()
            } catch (e: Exception) {
                resultTextView.text = "Error"
            }
        }
    }

    private fun evaluateExpression(expression: String): Double {
        val parts = expression.split("+", "-", "*", "/")
        if (parts.size != 2) {
            throw Exception("Invalid expression")
        }
        val operand1 = parts[0].toDouble()
        val operand2 = parts[1].toDouble()
        return when {
            expression.contains("+") -> operand1 + operand2
            expression.contains("-") -> operand1 - operand2
            expression.contains("*") -> operand1 * operand2
            expression.contains("/") -> operand1 / operand2
            else -> throw Exception("Invalid operator")
        }
    }
}

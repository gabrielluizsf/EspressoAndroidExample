import androidx.test.espresso.Espresso.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test

class CalculatorUnitTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testAddingNumbers() {
        // Press buttons 1, +, 2, =
        onView(withId(R.id.button1)).perform(click())
        onView(withId(R.id.buttonPlus)).perform(click())
        onView(withId(R.id.button2)).perform(click())
        onView(withId(R.id.buttonEquals)).perform(click())

        // Check that the result is 3
        onView(withId(R.id.resultTextView)).check(matches(withText("3.0")))
    }

    @Test
    fun testSubtractingNumbers() {
        // Press buttons 5, -, 3, =
        onView(withId(R.id.button5)).perform(click())
        onView(withId(R.id.buttonMinus)).perform(click())
        onView(withId(R.id.button3)).perform(click())
        onView(withId(R.id.buttonEquals)).perform(click())

        // Check that the result is 2
        onView(withId(R.id.resultTextView)).check(matches(withText("2.0")))
    }

    @Test
    fun testMultiplyingNumbers() {
        // Press buttons 2, *, 3, =
        onView(withId(R.id.button2)).perform(click())
        onView(withId(R.id.buttonMultiply)).perform(click())
        onView(withId(R.id.button3)).perform(click())
        onView(withId(R.id.buttonEquals)).perform(click())

        // Check that the result is 6
        onView(withId(R.id.resultTextView)).check(matches(withText("6.0")))
    }

    @Test
    fun testDividingNumbers() {
        // Press buttons 8, /, 2, =
        onView(withId(R.id.button8)).perform(click())
        onView(withId(R.id.buttonDivide)).perform(click())
        onView(withId(R.id.button2)).perform(click())
        onView(withId(R.id.buttonEquals)).perform(click())

        // Check that the result is 4
        onView(withId(R.id.resultTextView)).check(matches(withText("4.0")))
    }

    @Test
    fun testClearingResult() {
        // Press buttons 1, +, 2, C
        onView(withId(R.id.button1)).perform(click())
        onView(withId(R.id.buttonPlus)).perform(click())
        onView(withId(R.id.button2)).perform(click())
        onView(withId(R.id.buttonClear)).perform(click())

        // Check that the result is empty
        onView(withId(R.id.resultTextView)).check(matches(withText("")))
    }
}

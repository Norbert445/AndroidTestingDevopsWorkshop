package com.example.androidtestingdevopsworkshop.e2e

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import com.example.androidtestingdevopsworkshop.R
import com.example.androidtestingdevopsworkshop.ui.RegisterActivity
import org.junit.Test

@LargeTest
class RegisterEndToEndTest {

    @Test
    fun register() {
        ActivityScenario.launch(RegisterActivity::class.java)

        onView(withId(R.id.emailInput)).perform(typeText("norbi@gmail.com"))
        onView(withId(R.id.passwordInput)).perform(typeText("Heslo123"))
        onView(withId(R.id.confirmPasswordInput)).perform(typeText("Heslo12"), closeSoftKeyboard())

        onView(withId(R.id.btnRegister)).perform(click())

        onView(withText("Heslá sa nezhodujú")).check(matches(isDisplayed()))

        onView(withId(R.id.confirmPasswordInput)).perform(typeText("3"), closeSoftKeyboard())
        onView(withId(R.id.btnRegister)).perform(click())
        onView(withId(R.id.mainActivity)).check(matches(isDisplayed()))
    }
}
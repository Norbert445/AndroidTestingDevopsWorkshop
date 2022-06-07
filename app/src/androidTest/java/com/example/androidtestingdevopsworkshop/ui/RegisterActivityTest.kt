package com.example.androidtestingdevopsworkshop.ui

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isEnabled
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.example.androidtestingdevopsworkshop.R
import org.junit.Test


class RegisterActivityTest {

    @Test
    fun whenEnteredEmailAndPassword_thenButtonIsEnabled() {
        ActivityScenario.launch(RegisterActivity::class.java)

        onView(withId(R.id.emailInput)).perform(typeText("norbi@gmail.com"))
        onView(withId(R.id.passwordInput)).perform(typeText("heslo123"))

        onView(withId(R.id.btnRegister)).check(matches(isEnabled()))
    }
}
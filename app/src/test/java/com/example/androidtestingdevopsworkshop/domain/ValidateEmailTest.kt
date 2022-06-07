package com.example.androidtestingdevopsworkshop.domain

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class ValidateEmailTest {

    private lateinit var validateEmail: ValidateEmail

    @Before
    fun setUp() {
        validateEmail = ValidateEmail()
    }

    @Test
    fun whenEmailHasBadFormat_thenReturnsSuccessfulFalse() {
        val result = validateEmail.execute("norbi.com")
        assertEquals(result.isSuccessful, false)
    }

    @Test
    fun whenEmailIsEmpty_thenReturnsSuccessfulFalse() {
        val result = validateEmail.execute("")
        assertEquals(result.isSuccessful, false)
    }

    @Test
    fun whenEmailIsNotEmptyAndHasGoodFormat_thenReturnsSuccessfulTrue() {
        val result = validateEmail.execute("norbi@gmail.com")
        assertEquals(result.isSuccessful, true)
    }
}
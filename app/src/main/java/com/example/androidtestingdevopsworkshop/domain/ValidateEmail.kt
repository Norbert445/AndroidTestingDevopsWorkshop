package com.example.androidtestingdevopsworkshop.domain

import androidx.core.util.PatternsCompat

class ValidateEmail {
    fun execute(email: String): ValidationResult {
        if(email.isEmpty()) {
            return ValidationResult(
                isSuccessful = false,
                errorMessage = "Nezadali ste email"
            )
        }
        if(!PatternsCompat.EMAIL_ADDRESS.matcher(email).matches()) {
            return ValidationResult(
                isSuccessful = false,
                errorMessage = "Email má nesprávny formát"
            )
        }
        return ValidationResult(
            isSuccessful = true
        )
    }
}
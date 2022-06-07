package com.example.androidtestingdevopsworkshop.domain

class ValidateConfirmPassword {
    fun execute(password: String, confirmPassword: String): ValidationResult {
        if (password != confirmPassword) {
            return ValidationResult(
                isSuccessful = false,
                errorMessage = "Heslá sa nezhodujú"
            )
        }
        return ValidationResult(
            isSuccessful = true
        )
    }
}
package com.example.androidtestingdevopsworkshop.domain

class ValidatePassword {
    fun execute(password: String): ValidationResult {
        if(password.isEmpty()) {
            return ValidationResult(
                isSuccessful = false,
                errorMessage = "Nezadali ste heslo"
            )
        }
        val containsLettersAndDigits = password.any { it.isDigit() } && password.any { it.isLetter() }
        if(!containsLettersAndDigits) {
            return ValidationResult(
                isSuccessful = false,
                errorMessage = "Heslo musí obsahovať minimálne 1 písmeno a 1 číslo"
            )
        }
        if (password.length < 6) {
            return ValidationResult(
                isSuccessful = false,
                errorMessage = "Heslo musí obsahovať minimálne 6 znakov"
            )
        }
        return ValidationResult(
            isSuccessful = true
        )
    }
}
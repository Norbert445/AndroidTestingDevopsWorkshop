package com.example.androidtestingdevopsworkshop.domain

data class ValidationResult (
    val isSuccessful: Boolean,
    val errorMessage: String? = null
)
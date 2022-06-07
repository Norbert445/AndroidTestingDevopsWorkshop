package com.example.androidtestingdevopsworkshop.ui.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidtestingdevopsworkshop.arch.SingleLiveEvent
import com.example.androidtestingdevopsworkshop.domain.ValidateConfirmPassword
import com.example.androidtestingdevopsworkshop.domain.ValidateEmail
import com.example.androidtestingdevopsworkshop.domain.ValidatePassword

class RegisterViewModel(
    private val validateEmail: ValidateEmail = ValidateEmail(),
    private val validatePassword: ValidatePassword = ValidatePassword(),
    private val validateConfirmPassword: ValidateConfirmPassword = ValidateConfirmPassword(),
) : ViewModel() {

    val email = MutableLiveData("")
    val password = MutableLiveData("")
    val confirmPassword = MutableLiveData("")

    val emailError = MutableLiveData<String?>()
    val passwordError = MutableLiveData<String?>()
    val confirmPasswordError = MutableLiveData<String?>()

    val successfulRegistration = SingleLiveEvent<Nothing>()

    fun register() {
        emailError.value = null
        passwordError.value = null
        confirmPasswordError.value = null

        val emailResult = validateEmail.execute(email.value ?: "")
        if (!emailResult.isSuccessful) {
            emailError.value = emailResult.errorMessage
        }

        val passwordResult = validatePassword.execute(password.value ?: "")
        if (!passwordResult.isSuccessful) {
            passwordError.value = passwordResult.errorMessage
        }

        val confirmPasswordResult =
            validateConfirmPassword.execute(password.value ?: "", confirmPassword.value ?: "")
        if (!confirmPasswordResult.isSuccessful) {
            confirmPasswordError.value = confirmPasswordResult.errorMessage
        }

        val hasError =
            listOf(emailResult, passwordResult, confirmPasswordResult).any { !it.isSuccessful }
        if(!hasError) successfulRegistration.call()
    }

}
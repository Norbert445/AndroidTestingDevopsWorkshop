package com.example.androidtestingdevopsworkshop.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.androidtestingdevopsworkshop.databinding.ActivityRegisterBinding
import com.example.androidtestingdevopsworkshop.ui.presentation.RegisterViewModel


class RegisterActivity : AppCompatActivity() {

    private val viewModel: RegisterViewModel by viewModels()
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.registerViewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.successfulRegistration.observe(this) {
            startActivity(Intent(this, MainActivity::class.java))
        }
        viewModel.emailError.observe(this) {
            binding.tilEmail.error = it
        }
        viewModel.passwordError.observe(this) {
            binding.tilPassword.error = it
        }
        viewModel.confirmPasswordError.observe(this) {
            binding.tilConfirmPassword.error = it
        }
    }
}
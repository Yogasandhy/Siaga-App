package com.example.siaga

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import com.example.siaga.data.UserRepository
import com.example.siaga.ui.login.LoginViewModel
import com.example.siaga.ui.register.RegisterViewModel

class ViewModelFactory(private val userRepository: UserRepository,private val navController: NavController) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            return LoginViewModel(userRepository, navController) as T
        }

        if (modelClass.isAssignableFrom(RegisterViewModel::class.java)) {
            return RegisterViewModel(userRepository, navController) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
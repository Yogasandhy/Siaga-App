package com.example.siaga.ui.login

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.siaga.data.UserRepository
import com.example.siaga.data.response.LoginResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel(private val userRepository: UserRepository, private val navController: NavController) : ViewModel() {

    private val _isLoading = mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading

    fun login(email: String, password: String) {
        _isLoading.value = true
        userRepository.loginUser(email, password).enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if (response.isSuccessful) {
                    val loginResponse = response.body()
                    println("Login berhasil dengan email: ${loginResponse?.loginResult?.email}")
                    Log.d("LoginViewModel", "Check login: ${loginResponse}" )

                    navController.navigate("home")
                } else {
                    println("Login gagal: ${response.errorBody()?.string()}")
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                _isLoading.value = false
                println("Terjadi kesalahan jaringan: ${t.message}")
            }
        })
    }
}

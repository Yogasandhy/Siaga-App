package com.example.siaga.ui.register

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.siaga.data.UserRepository
import com.example.siaga.data.response.RegisterResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterViewModel(private val userRepository: UserRepository, private val navController: NavController) : ViewModel() {

    private val _isLoading = mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading

    fun register(email: String, password: String, repassword: String) {
        _isLoading.value = true
        userRepository.registerUser(email, password, repassword).enqueue(object : Callback<RegisterResponse> {
            override fun onResponse(call: Call<RegisterResponse>, response: Response<RegisterResponse>) {
                if (password != repassword) {
                    println("Password dan repassword tidak sama")
                    return
                }

                if (response.isSuccessful) {
                    val registerResponse = response.body()
                    Log.d("RegisterViewModel", "Check Register: ${registerResponse}")

                    navController.navigate("home")
                } else {
                    _isLoading.value = false
                    println("Register gagal: ${response.errorBody()?.string()}")
                }
            }

            override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                _isLoading.value = false
                println("Terjadi kesalahan jaringan: ${t.message}")
            }
        })
    }


}
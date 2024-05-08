package com.example.siaga.data

import com.example.siaga.data.api.ApiService
import com.example.siaga.data.response.LoginResponse
import com.example.siaga.data.pref.UserModel
import com.example.siaga.data.response.RegisterResponse
import retrofit2.Call

class UserRepository(private val apiService: ApiService) {
    fun loginUser(email: String, password: String): Call<LoginResponse> {
        return apiService.login(UserModel(email, password))
    }

    fun registerUser(email: String, password: String, repassword: String): Call<RegisterResponse> {
        return apiService.register(UserModel(email, password, repassword))
    }

    // add post login
    
}

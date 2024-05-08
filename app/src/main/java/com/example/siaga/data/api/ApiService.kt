package com.example.siaga.data.api

import com.example.siaga.data.pref.UserModel
import com.example.siaga.data.response.LoginResponse
import com.example.siaga.data.response.RegisterResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("login")
    fun login(@Body loginData: UserModel): Call<LoginResponse>

    @POST("register")
    fun register(@Body registerData: UserModel): Call<RegisterResponse>
}
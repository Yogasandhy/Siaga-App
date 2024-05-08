package com.example.siaga.data.pref

data class UserModel(
    val email: String,
    val password: String,
    val repassword: String? = null,
    val username: String? = null,
    val fullname: String? = null,
    val image: String? = null,
    val token: String? = null,
    val createdAt: String? = null,
    val updatedAt: String? = null
)

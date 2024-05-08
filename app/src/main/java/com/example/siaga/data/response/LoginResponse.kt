package com.example.siaga.data.response

import com.google.gson.annotations.SerializedName

data class LoginResponse(
	@field:SerializedName("code")
	val code: Int,

	@field:SerializedName("success")
	val success: Boolean,

	@field:SerializedName("message")
	val message: String,

	@field:SerializedName("data")
	val loginResult: LoginResult? = null
)

data class LoginResult(
	@field:SerializedName("id")
	val id: String,

	@field:SerializedName("username")
	val username: String? = null,

	@field:SerializedName("email")
	val email: String,

	@field:SerializedName("fullname")
	val fullname: String? = null,

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("token")
	val token: String,

	@field:SerializedName("created_at")
	val createdAt: String,

	@field:SerializedName("updated_at")
	val updatedAt: String
)

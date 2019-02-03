package br.com.fiap.fiapmoney.oauth2authentication.model.model.request

import java.io.Serializable

data class Auth(val username: String,
                val password: String,
                val client: String = "mobile",
                val grant_type: String = "password") : Serializable
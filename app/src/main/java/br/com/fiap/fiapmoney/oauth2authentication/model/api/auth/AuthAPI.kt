package br.com.fiap.fiapmoney.oauth2authentication.model.api.auth


import br.com.fiap.fiapmoney.oauth2authentication.model.model.request.Auth
import br.com.fiap.fiapmoney.oauth2authentication.model.model.request.Refresh
import br.com.fiap.fiapmoney.oauth2authentication.model.oauth.Token
import retrofit2.Call
import retrofit2.http.*

interface AuthAPI {

    /**
     * Your endpoint of auth
     */
    @Headers("Authorization: Basic bW9iaWxlOm0wYjFsMzA=", "Content-Type: application/x-www-form-urlencoded")
    @FormUrlEncoded
    @POST("/oauth/token")
    fun auth(
        @Field("client") client: String,
        @Field("username") username: String,
        @Field("password") password: String,
        @Field("grant_type"
        ) grant_type: String
    ): Call<Token>

    /**
     * Your endpoint of refresh your token
     */
    @POST("/oauth/token")
    fun refresh(@Body refreshAuth: Refresh): Call<Token>
}
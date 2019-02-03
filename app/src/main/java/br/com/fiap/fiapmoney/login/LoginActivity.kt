package br.com.fiap.fiapmoney.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import br.com.fiap.fiapmoney.R
import br.com.fiap.fiapmoney.base.BaseMVPActivity
import br.com.fiap.fiapmoney.home.HomeActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseMVPActivity<LoginContract.LoginView, LoginContract.LoginPresenter>(),
    LoginContract.LoginView {

    override var presenter: LoginContract.LoginPresenter = LoginPresenterImpl()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)

        btLogin.setOnClickListener {
            if(isValid()){
                loading(true)

                presenter.login(inputLoginEmail.text.toString(), inputLoginPassword.text.toString())
            }
        }
    }

    private fun isValid(): Boolean {
        if(inputLoginEmail?.text.toString().isNullOrEmpty()) return false
        if(inputLoginPassword?.text.toString().isNullOrEmpty()) return false
        return true
    }

    override fun onSuccess() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun loading(value: Boolean){
        if(value) progressBar.visibility = View.VISIBLE
        else progressBar.visibility = View.GONE

        if(!value){
            inputLoginEmail.text.clear()
            inputLoginPassword.text.clear()
        }

        if(!value) inputLayoutEmail.visibility = View.VISIBLE
        else inputLayoutEmail.visibility = View.GONE

        if(!value) inputLayoutPassword.visibility = View.VISIBLE
        else inputLayoutPassword.visibility = View.GONE
    }

    override fun onFailed(e: String) {
        loading(false)
        Toast.makeText(this@LoginActivity,
            e, Toast.LENGTH_SHORT).show()
    }

    override fun onError(e: Throwable) {
        loading(false)
        Toast.makeText(this@LoginActivity,
            e.message.toString(), Toast.LENGTH_SHORT).show()
    }
}

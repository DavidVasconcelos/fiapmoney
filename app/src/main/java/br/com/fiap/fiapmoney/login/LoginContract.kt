package br.com.fiap.fiapmoney.login

import br.com.fiap.fiapmoney.base.BaseMVPPresenter
import br.com.fiap.fiapmoney.base.BaseMVPView

object LoginContract {

    interface LoginView : BaseMVPView {
        fun onSuccess()
        fun onFailed(e: String)
        fun onError(e: Throwable)
    }

    interface LoginPresenter : BaseMVPPresenter<LoginView> {
        fun login(email: String, password: String)
        fun cancel()
    }
}
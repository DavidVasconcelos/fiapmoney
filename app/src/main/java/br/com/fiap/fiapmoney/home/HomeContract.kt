package br.com.fiap.fiapmoney.home

import br.com.fiap.fiapmoney.base.BaseMVPPresenter
import br.com.fiap.fiapmoney.base.BaseMVPView

object HomeContract {

    interface HomeView : BaseMVPView {
        fun onLogout()
    }

    interface HomePresenter : BaseMVPPresenter<HomeView> {
        fun signOut()
    }
}
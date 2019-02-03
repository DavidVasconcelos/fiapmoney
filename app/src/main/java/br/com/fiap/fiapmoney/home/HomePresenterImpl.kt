package br.com.fiap.fiapmoney.home

import br.com.fiap.fiapmoney.base.BaseMVPPresenterImpl
import br.com.fiap.fiapmoney.oauth2authentication.model.util.Authentication

class HomePresenterImpl : BaseMVPPresenterImpl<HomeContract.HomeView>(),
        HomeContract.HomePresenter {

    override fun signOut() {
        Authentication.delete(getContext())

        view?.let { view -> call(view, view::onLogout)}
    }
}
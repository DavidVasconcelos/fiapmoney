package br.com.fiap.fiapmoney.base

interface BaseMVPPresenter<in V : BaseMVPView> {
    fun attachView(view: V)
    fun detachView()
}
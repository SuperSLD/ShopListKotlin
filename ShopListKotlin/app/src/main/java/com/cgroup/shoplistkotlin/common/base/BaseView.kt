package pro.midev.gurmanica.common.base

import com.arellomobile.mvp.MvpView

interface BaseView : MvpView {
    fun showLoading()

    fun hideLoading()
}
package pro.midev.gurmanica.ui.splash

import android.os.Bundle
import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.presenter.InjectPresenter
import com.cgroup.shoplistkotlin.R
import pro.midev.gurmanica.common.base.BaseFragment

class SplashFragment : BaseFragment(R.layout.fragment_splash), MvpView {

    @InjectPresenter
    lateinit var presenter: SplashPresenter

    override fun onBackPressed() {
        presenter.back()
    }
}
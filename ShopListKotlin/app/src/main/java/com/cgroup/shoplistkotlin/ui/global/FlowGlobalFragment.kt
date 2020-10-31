package com.cgroup.shoplistkotlin.ui.global

import android.os.Bundle
import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.presenter.InjectPresenter
import com.cgroup.shoplistkotlin.R
import com.cgroup.shoplistkotlin.Screens
import kotlinx.android.synthetic.main.layout_container.view.*
import pro.midev.gurmanica.common.base.FlowFragment
import pro.midev.gurmanica.ui.global.GlobalPresenter
import pro.midev.gurmanica.ui.global.GlobalView
import ru.terrakok.cicerone.commands.BackTo
import ru.terrakok.cicerone.commands.Replace

class FlowGlobalFragment(router : String) : FlowFragment(router), GlobalView{
    @InjectPresenter
    lateinit var presenter: GlobalPresenter

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (childFragmentManager.fragments.isEmpty()) {
            navigator.applyCommands(
                arrayOf(
                    BackTo(null),
                    Replace(Screens.Splash)
                )
            )
        }
    }

}
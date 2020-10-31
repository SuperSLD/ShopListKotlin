package com.cgroup.shoplistkotlin.ui.list

import android.os.Bundle
import com.cgroup.shoplistkotlin.Screens
import pro.midev.gurmanica.common.base.FlowFragment
import ru.terrakok.cicerone.commands.BackTo
import ru.terrakok.cicerone.commands.Replace

class FlowListFragment(router : String) : FlowFragment(router) {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (childFragmentManager.fragments.isEmpty()) {
            navigator.applyCommands(
                arrayOf(
                    BackTo(null),
                    Replace(Screens.ShopList)
                )
            )
        }
    }
}
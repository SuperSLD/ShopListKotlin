package com.cgroup.shoplistkotlin

import androidx.fragment.app.Fragment
import com.cgroup.shoplistkotlin.datamodels.ListItems
import com.cgroup.shoplistkotlin.ui.global.FlowGlobalFragment
import com.cgroup.shoplistkotlin.ui.list.FlowListFragment
import com.cgroup.shoplistkotlin.ui.list.create.CreateItemFragment
import com.cgroup.shoplistkotlin.ui.list.shop_list.ShopListFragment
import pro.midev.gurmanica.ui.splash.SplashFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

object Screens {
    const val APP_ROUTER = "APP_ROUTER"
    object FlowGlobal : SupportAppScreen() {
        override fun getFragment() = FlowGlobalFragment(APP_ROUTER)
    }

    object Splash : SupportAppScreen() {
        override fun getFragment() = SplashFragment()
    }

    const val LIST_ROUTER = "LIST_ROUTER"
    object FlowList : SupportAppScreen() {
        override fun getFragment(): Fragment? = FlowListFragment(LIST_ROUTER)
    }

    object ShopList : SupportAppScreen() {
        override fun getFragment(): Fragment? = ShopListFragment()
    }

    data class CreateItem(val item: ListItems?) : SupportAppScreen() {
        override fun getFragment(): Fragment? = CreateItemFragment(item)
    }
}
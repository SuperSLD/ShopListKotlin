package com.cgroup.shoplistkotlin.ui.list.shop_list

import com.cgroup.shoplistkotlin.Screens
import com.cgroup.shoplistkotlin.common.CiceroneHolder
import com.cgroup.shoplistkotlin.data_managers.ShopListManager
import com.cgroup.shoplistkotlin.datamodels.ListItems
import org.koin.core.inject
import pro.midev.gurmanica.common.base.BasePresenter
import ru.terrakok.cicerone.Router

class ShopListPresenter : BasePresenter<ShopView>() {

    private val navigationHolder: CiceroneHolder by inject()
    private val router: Router?
        get() = navigationHolder.currentRouter

    private val shopListManager : ShopListManager by inject()

    private lateinit var shopList : ListItems

    fun createNewListItem(item: ListItems?) {
        router?.navigateTo(Screens.CreateItem(item))
    }

    fun deleteItem(id : Int) {
        shopListManager.deleteItem(id)
    }

    fun back() {
        router?.exit()
    }
}
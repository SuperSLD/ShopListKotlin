package com.cgroup.shoplistkotlin.ui.list.create

import com.cgroup.shoplistkotlin.common.CiceroneHolder
import com.cgroup.shoplistkotlin.data_managers.ShopListManager
import com.cgroup.shoplistkotlin.datamodels.ListItems
import com.cgroup.shoplistkotlin.datamodels.Purchase
import org.koin.core.inject
import pro.midev.gurmanica.common.base.BasePresenter
import ru.terrakok.cicerone.Router

class CreateItemPresenter : BasePresenter<CreateItemView>() {
    private val navigationHolder: CiceroneHolder by inject()
    private val router: Router?
        get() = navigationHolder.currentRouter

    private val shopListManager : ShopListManager by inject()

    fun addNewItem(name: String, itemsList: ArrayList<Purchase>) {
        var item = ListItems(name)
        item.setNewList(itemsList)
        shopListManager.addItem(item)
        shopListManager.save()

        back()
    }

    fun rewriteItem(
        item: ListItems?,
        newName: String,
        newList: ArrayList<Purchase>) {
        item?.setName(newName)
        item?.setNewList(newList)
        shopListManager.save()

        back()
    }

    fun back() {
        router?.exit()
    }
}
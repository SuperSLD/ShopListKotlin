package com.cgroup.shoplistkotlin.data_managers

import com.cgroup.shoplistkotlin.datamodels.ListItems
import com.cgroup.shoplistkotlin.datamodels.Purchase
import com.cgroup.shoplistkotlin.db.ListItemsRealmModel
import com.cgroup.shoplistkotlin.db.PurchaseRealmModel
import io.realm.Realm
import io.realm.kotlin.delete
import java.util.logging.Level
import java.util.logging.Logger

class ShopListManager {
    private lateinit var list : ArrayList<ListItems>

    fun init() : ShopListManager {
        list = arrayListOf()

        var realm = Realm.getDefaultInstance()
        var results = realm.where(ListItemsRealmModel::class.java).findAll()
        results.forEach {
            var listItems = ListItems(name = it.name)
            it.list.forEach {
                var item = Purchase(it.name)
                listItems.addItem(item)
            }
            list.add(listItems)
        }

        return this
    }

    fun getList() : ArrayList<ListItems> = list

    fun addItem(item : ListItems) {
        this.list.add(0, item)
    }

    /**
     * Сохранение списка записей.
     */
    fun save() {
        var realm = Realm.getDefaultInstance()
        realm.beginTransaction()
        realm.delete(ListItemsRealmModel::class.java)
        realm.commitTransaction()

        for(i in 0 until list.size) {
            var listItemsRealmModel = ListItemsRealmModel()
            listItemsRealmModel.id = i
            list[i].id = i
            listItemsRealmModel.name = list[i].getName()
            for (j in 0 until list[i].getAllList().size) {
                var purchaseRealmModel = PurchaseRealmModel()
                purchaseRealmModel.name = list[i].getAllList()[j].getName()
                listItemsRealmModel.list.add(purchaseRealmModel)
            }

            realm.beginTransaction()
            realm.copyToRealmOrUpdate(listItemsRealmModel)
            realm.commitTransaction()
        }
        realm.close()
    }

    /**
     * Удаление обхекта из реалма (возможно)
     */
    fun deleteItem(id : Int) {
        var realm = Realm.getDefaultInstance()

        realm.executeTransaction {
            var realmResult = it.where(ListItemsRealmModel::class.java).equalTo("id", id).findFirst()
            realmResult?.deleteFromRealm()
        }

        list.forEach {
            if (it.id == id) {
                list.remove(it)
                return
            }
        }
    }
}
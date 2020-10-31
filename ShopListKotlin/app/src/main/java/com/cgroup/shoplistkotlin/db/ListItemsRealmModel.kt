package com.cgroup.shoplistkotlin.db

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.Required

open class ListItemsRealmModel : RealmObject() {
    @PrimaryKey
    var id : Int = 0
    @Required
    lateinit var name : String

    var list : RealmList<PurchaseRealmModel> = RealmList()
}
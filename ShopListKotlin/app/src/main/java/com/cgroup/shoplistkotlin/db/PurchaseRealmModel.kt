package com.cgroup.shoplistkotlin.db

import io.realm.RealmObject
import io.realm.annotations.Required

open class PurchaseRealmModel : RealmObject() {
    @Required
    lateinit var name : String
}
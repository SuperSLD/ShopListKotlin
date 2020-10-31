package com.cgroup.shoplistkotlin.datamodels

import java.util.ArrayList

open class ListItems(name: String) {
    var id : Int = 0
    private var name = name
    var list: ArrayList<Purchase> = arrayListOf()

    fun addItem(purchase: Purchase) {
        list.add(purchase)
    }

    fun setName(name: String){
        this.name = name
    }
    fun getName(): String = this.name

    fun getItem(index: Int): Purchase = list.get(index)
    fun getAllList(): ArrayList<Purchase> = list

    fun setNewList(list : ArrayList<Purchase>) {
        this.list = list
    }
}
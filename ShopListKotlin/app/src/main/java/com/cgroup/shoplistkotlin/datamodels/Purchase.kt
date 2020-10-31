package com.cgroup.shoplistkotlin.datamodels

class Purchase(name: String) {
    private var name: String = name
    private var count: Int = 0
    private var unit: String? = null

    fun setName(name: String) {
        this.name = name
    }

    fun setCount(count: Int) {
        this.count = count
    }

    fun setUnit(unit: String) {
        this.unit = unit
    }

    fun getName(): String {
        return this.name;
    }

    fun getCount(): Int {
        return this.count
    }

    fun getUnit(): String? {
        return this.unit
    }
}
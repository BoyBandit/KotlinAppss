package com.ruiwenliu.kotlin.mvvm.bean

class ItemBottomBean(override val itemType: Int) :MultiItemBean {
    var star:Int?=null;

    override fun getSpanSize(): Int {
        return 10;
    }
}
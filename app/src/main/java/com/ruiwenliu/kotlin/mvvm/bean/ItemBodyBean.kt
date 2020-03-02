package com.ruiwenliu.kotlin.mvvm.bean

class ItemBodyBean(override val itemType: Int) :MultiItemBean{
    var drawable:Int?=null;

    override fun getSpanSize(): Int {
        return 3;
    }

}
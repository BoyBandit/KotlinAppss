package com.ruiwenliu.kotlin.mvvm.bean

class ItemHeadBean(override val itemType: Int) :MultiItemBean{

    var title:String?=null;

    override fun getSpanSize(): Int {
        return 10;
    }


}
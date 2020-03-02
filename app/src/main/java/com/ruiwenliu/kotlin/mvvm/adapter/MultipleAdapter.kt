package com.ruiwenliu.kotlin.mvvm.adapter

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.ruiwenliu.kotlin.R
import com.ruiwenliu.kotlin.mvvm.bean.ItemBodyBean
import com.ruiwenliu.kotlin.mvvm.bean.ItemBottomBean
import com.ruiwenliu.kotlin.mvvm.bean.ItemHeadBean
import com.ruiwenliu.kotlin.mvvm.bean.MultiItemBean

class MultipleAdapter : BaseMultiItemQuickAdapter<MultiItemBean,BaseViewHolder>(){

    companion object{
        const val TYPE_ITEM_HEAD=1;
        const val TYPE_ITEM_BODY=2;
        const val TYPE_ITEM_BOTTOM=3;
    }

    init {
        addItemType(TYPE_ITEM_HEAD, R.layout.multiplel_item_head)
        addItemType(TYPE_ITEM_BODY, R.layout.multiplel_item_body)
        addItemType(TYPE_ITEM_BOTTOM, R.layout.multiplel_item_bottom)
    }
    override fun convert(helper: BaseViewHolder, item: MultiItemBean?) {
            when(helper.itemViewType){
                TYPE_ITEM_HEAD->processHead(helper,item as ItemHeadBean)
                TYPE_ITEM_BODY->processBody(helper,item as ItemBodyBean)
                TYPE_ITEM_BOTTOM->processBottom(helper,item as ItemBottomBean)

            }
    }

    fun  processHead(helper: BaseViewHolder,item : ItemHeadBean){
        helper.setText(R.id.tv_head,item.title)

    }

    fun  processBody(helper: BaseViewHolder,item : ItemBodyBean){
        helper.setBackgroundResource(R.id.iv_body, R.mipmap.ic_launcher_round)
//        item.drawable?.let { helper.setBackgroundResource(R.id.iv_body, it) }
    }

    fun  processBottom(helper: BaseViewHolder,item : ItemBottomBean){
        helper.setText(R.id.tv_star,"点赞"+item.star)
    }
}
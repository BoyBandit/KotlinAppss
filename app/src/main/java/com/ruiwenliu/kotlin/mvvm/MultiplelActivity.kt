package com.ruiwenliu.kotlin.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ruiwenliu.kotlin.R
import kotlinx.android.synthetic.main.activity_list.*
import androidx.recyclerview.widget.GridLayoutManager
import com.ruiwenliu.kotlin.mvvm.adapter.MultipleAdapter
import com.ruiwenliu.kotlin.mvvm.bean.ItemBodyBean
import com.ruiwenliu.kotlin.mvvm.bean.ItemBottomBean
import com.ruiwenliu.kotlin.mvvm.bean.ItemHeadBean
import com.ruiwenliu.kotlin.mvvm.bean.MultiItemBean


class MultiplelActivity : AppCompatActivity() {

    val starArray:IntArray= intArrayOf(3,5,26,8);
    val drawableArray:IntArray= intArrayOf(R.mipmap.ic_launcher_round,R.mipmap.ic_launcher_round,R.mipmap.ic_launcher_round,R.mipmap.ic_launcher_round);
    val strArray: Array<String> = arrayOf(
        "Kotlin 是一个用于现代多平台应用的静态编程语言 [1]  ，由 JetBrains 开发。",
        "Kotlin可以编译成Java字节码，也可以编译成JavaScript，方便在没有JVM的设备上运行。",
        "Kotlin已正式成为Android官方支持开发语言。",
        "JetBrains，作为广受欢迎的 Java IDE IntelliJ 的提供商，在 Apache 许可下已经开源其Kotlin 编程语言。")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multiplel)
        recycler_view.layoutManager= GridLayoutManager(this, 10);
        var list=getListData();
        var adapter=MultipleAdapter();
        adapter.setGridSpanSizeLookup { gridLayoutManager, viewType, position -> list.get(position).getSpanSize() }
        adapter.setNewData(list)
        recycler_view.adapter=adapter;
    }


    fun getListData():MutableList<MultiItemBean>{
       val list=ArrayList<MultiItemBean>();

        for (index in 0..3){
            val hBean=ItemHeadBean(MultipleAdapter.TYPE_ITEM_HEAD)
            hBean.title=strArray[index]
            list.add(hBean)
            for (i in 0..3){
                val bBean= ItemBodyBean(MultipleAdapter.TYPE_ITEM_BODY)
                bBean.drawable=drawableArray[i]
                list.add(bBean)
            }
            val bottomBean= ItemBottomBean(MultipleAdapter.TYPE_ITEM_BOTTOM)
            bottomBean.star=starArray[index]


            list.add(bottomBean)
        }


        return list;
    }
}

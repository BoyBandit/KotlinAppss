package com.ruiwenliu.kotlin.moudle.ui

import android.view.View
import android.widget.TableLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.ruiwenliu.kotlin.R
import com.ruiwenliu.kotlin.moudle.ApiConfig
import com.ruiwenliu.kotlin.moudle.BannerBean
import com.ruiwenliu.kotlin.moudle.MainPresenter
import com.ruiwenliu.kotlin.moudle.base.BaseWrapperActivity
import com.ruiwenliu.kotlin.moudle.base.bean.BaseBean
import com.ruiwenliu.kotlin.moudle.ui.adapter.MenuAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_project_list.*

class MainActivity : BaseWrapperActivity<MainPresenter>() {
    val  tablayout:TableLayout?=null
    override fun <T : BaseBean> onShowResult(requestType: Int?, result: T) {
        when(requestType){
            0->inputData(result as BannerBean)
        }
    }

    override fun getLayout(): Int {
        return  R.layout.activity_main
    }


    override fun intiView() {
        tv_getContext.setOnClickListener(View.OnClickListener {
            mPresenter?.getData(0,
                ApiConfig.HTTP_BANNER, BannerBean::class.java, true)
        })

    }


    fun inputData(banner: BannerBean){
        Toast.makeText(this, banner.getData()?.get(0)?.title, Toast.LENGTH_SHORT).show()
    }
}

package com.ruiwenliu.kotlin.moudle.ui.test

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.ruiwenliu.kotlin.R
import com.ruiwenliu.kotlin.databinding.ActivityMBinding
import com.ruiwenliu.kotlin.databinding.ActivityTestBinding
import com.ruiwenliu.kotlin.mvvm.MainViewModel
import com.ruiwenliu.kotlin.mvvm.TestViewModel
import kotlinx.android.synthetic.main.activity_test.*

/*   
* @Author:      Amuser
* @CreateDate:   2019-12-23 14:56
*@Description: 
*/
class TestMvvm : AppCompatActivity() {
    var  _binding:ActivityTestBinding?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    _binding =DataBindingUtil.setContentView(this,R.layout.activity_test);
//        var  _binding=DataBindingUtil.setContentView(this,R.layout.activity_test) as ActivityMBinding
        var testBean= TestViewModel()
//        var  viewModel= MainViewModel()
        _binding?.test=testBean
//        _binding?.user=viewModel
        _binding?.lifecycleOwner=this

        var mainModel=ViewModelProviders.of(this).get(MainViewModel().javaClass)
//        var mainModel=ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication())).get(MainViewModel().javaClass);

        btn_test.setOnClickListener({
//            mainModel.name.value="大道朝天";
            Toast.makeText(this, mainModel.name.value, Toast.LENGTH_SHORT).show();

        })
    }

}
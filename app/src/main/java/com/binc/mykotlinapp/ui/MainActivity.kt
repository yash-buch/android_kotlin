package com.binc.mykotlinapp.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.binc.mykotlinapp.R
import com.binc.mykotlinapp.adapter.ListAdapter
import com.binc.mykotlinapp.bean.Item
import com.binc.mykotlinapp.model.ListViewModel
import com.binc.mykotlinapp.ui.viewmanager.ViewManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rv_item_list.layoutManager = LinearLayoutManager(this)
        lifecycle.addObserver(ViewManager(button, editText, application))

        var lvModel: ListViewModel = ViewModelProviders.of(this).get(ListViewModel::class.java)
        lvModel.getItems(application).observe(this, Observer<List<Item>>(::updateUI))

    }

    fun updateUI(list:List<Item>?) {
        Log.i("yash", "changed")
        rv_item_list.adapter = ListAdapter(list, this)
    }
}

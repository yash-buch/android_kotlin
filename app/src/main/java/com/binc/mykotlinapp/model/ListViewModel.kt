package com.binc.mykotlinapp.model

import android.app.Application
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.binc.mykotlinapp.bean.Item
import com.binc.mykotlinapp.bean.ItemDao
import com.binc.mykotlinapp.database.ItemRoomDatabase

class ListViewModel: ViewModel() {
    var listItems: LiveData<List<Item>>? = null

    fun getItems(app: Application): LiveData<List<Item>> {
        if(listItems == null) {
            loadItems(app)
        }
        return listItems as LiveData<List<Item>>
    }

    private fun loadItems(app: Application): Unit {
        //fetch data from data source and set listItems
        val db: ItemRoomDatabase = ItemRoomDatabase.getInstance(app)
        val mItemDao: ItemDao = db.ItemDao()
        listItems = mItemDao.getAllItems()
    }
}
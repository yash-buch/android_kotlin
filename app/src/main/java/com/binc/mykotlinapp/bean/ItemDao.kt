package com.binc.mykotlinapp.bean

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface ItemDao {
    @Insert
    fun insertItem(item: Item)

    @Query("DELETE FROM items")
    fun deleteAll()

    @Query("SELECT * from items ORDER BY item ASC")
    fun getAllItems(): LiveData<List<Item>>
}
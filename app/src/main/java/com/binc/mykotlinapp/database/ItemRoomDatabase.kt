package com.binc.mykotlinapp.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.binc.mykotlinapp.bean.Item
import com.binc.mykotlinapp.bean.ItemDao

@Database(entities = arrayOf(Item::class), version = 1)
abstract class ItemRoomDatabase: RoomDatabase() {
    abstract fun ItemDao():ItemDao

    companion object {
        private val DB_NAME = "ItemsDatabase"
        @Volatile private var INSTANCE: ItemRoomDatabase? = null

        fun getInstance(context: Context): ItemRoomDatabase =
                INSTANCE ?: synchronized(this) {
                    INSTANCE ?: this.buildDatabase(context).
                            also { INSTANCE = it }
                }

        private fun buildDatabase(context: Context) =
                Room.databaseBuilder(context.applicationContext,
                        ItemRoomDatabase::class.java, DB_NAME)
                        .build()
    }
}
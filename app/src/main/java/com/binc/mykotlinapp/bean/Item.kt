package com.binc.mykotlinapp.bean

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.support.annotation.NonNull

@Entity(tableName = "items")
data class Item(
        @PrimaryKey(autoGenerate = true) val id: Int? = null,
        @ColumnInfo(name = "item") val item: String) {
}
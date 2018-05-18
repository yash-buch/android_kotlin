package com.binc.mykotlinapp.ui.viewmanager

import android.app.Application
import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.binc.mykotlinapp.bean.Item
import com.binc.mykotlinapp.database.ItemRoomDatabase

class ViewManager(val btn: Button, val et: EditText, val app: Application) : LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun activityCreated(): Unit {
        btn.setOnClickListener(View.OnClickListener {
            var value = et?.text.toString()
            Log.i("yash", "btn clicked:" + value)
            var t: MyThread = MyThread(app, value)
            t.start()
        })
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun activityDestroyed(): Unit {
        btn.setOnClickListener(null)
    }

    class MyThread(val app: Application, val value: String) : Thread() {
        override fun run() {
            super.run()
            Log.i("yash", "inserted:" + value)
            ItemRoomDatabase.getInstance(app).ItemDao().insertItem(Item(item = value))
        }
    }
}
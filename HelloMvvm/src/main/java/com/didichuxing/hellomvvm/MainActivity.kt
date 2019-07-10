package com.didichuxing.hellomvvm

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.didichuxing.hellomvvm.bean.Comic
import com.didichuxing.hellomvvm.lifecycle.MainPresenter
import com.didichuxing.hellomvvm.viewmodel.ComicViewModel

class MainActivity : AppCompatActivity() {

    private var mToast: Toast ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 测试ViewModel
        val viewModel = ViewModelProviders.of(this).get(ComicViewModel::class.java)
        viewModel.getComic().observe(this, Observer<Comic> {
            showToast(it?.name ?: "null")
        })

        // 测试Lifecycle
        lifecycle.addObserver(MainPresenter())

        // 测试LiveData
        val livedata = MutableLiveData<Comic>()
        livedata.value = Comic("龙珠", 42)
        livedata.observe(this, Observer<Comic> {
            Log.d("xu", "livedata comic is onChanged: " + it!!.name)
        })

        findViewById<Button>(R.id.btn).setOnClickListener {
            livedata.value = Comic("哆啦A梦", 45)
        }
    }

    fun showToast(str: String) {
        if (mToast == null) {
            mToast = Toast.makeText(this, str, Toast.LENGTH_SHORT)
        }
        mToast?.setText(str)
        mToast?.show()
    }
}

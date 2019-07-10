package com.didichuxing.hellomvvm.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.os.Handler
import com.didichuxing.hellomvvm.bean.Comic

/**
 * <title>
 *
 * Created by didi on 2019-06-27.
 */
class ComicViewModel : ViewModel() {

    private val comicLiveData: MutableLiveData<Comic> by lazy {
        MutableLiveData<Comic>()
    }

    fun getComic() : MutableLiveData<Comic> {
        loadComicInfo()
        return comicLiveData
    }

    private fun loadComicInfo() {
        //模拟网络请求
        //注意：ViewModel应该作为UI和其它部分的连接服务，所以不应由ViewModel负责获取数据(例如从网络获取)，而是调用相应的组件获取数据，然后将数据获取结果提供给UI。
        Handler().postDelayed(Runnable {
            kotlin.run {
                comicLiveData.postValue(Comic("灌篮高手", 31))
            }
        }, 5000)
    }
}
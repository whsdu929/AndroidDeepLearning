package com.didichuxing.hellomvvm.lifecycle

import android.util.Log

/**
 * <title>
 *
 * Created by didi on 2019-07-10.
 */
class MainPresenter : BasePresenter {

    override fun onResume() {
        Log.d("xu", "MainPresenter - onResume")
    }

    override fun onPause() {
        Log.d("xu", "MainPresenter - onPause")
    }
}
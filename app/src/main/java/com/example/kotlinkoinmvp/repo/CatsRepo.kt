package com.example.ainfo.repo

import android.util.Log
import com.example.ainfo.utils.AnimeApiClient
import com.example.kotlinkoinmvp.presenter.catspresImpl
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class CatsRepo constructor() {
   lateinit var topcats: catspresImpl
    val client by lazy {
        AnimeApiClient.create()
    }

    var disposable: Disposable? = null

    fun getcats( x : Int ){

        disposable = client.getCats(x)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { result -> Log.v("cats", "" + result)
                   topcats.catsimages(result)
                },
                { error -> Log.e("ERROR", error.message) }
            )
    }




}
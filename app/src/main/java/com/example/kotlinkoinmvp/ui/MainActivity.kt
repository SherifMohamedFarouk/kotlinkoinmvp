package com.example.kotlinkoinmvp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.example.kotlinkoinmvp.R
import com.example.kotlinkoinmvp.adapters.CatsAdapter
import com.example.kotlinkoinmvp.model.catts
import com.example.kotlinkoinmvp.presenter.MainCats
import com.example.kotlinkoinmvp.presenter.catspresImpl
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity(),MainCats {
 val catspresImpl: catspresImpl by inject()
//    val businessService: BusinessService by inject()
    lateinit var catsAdapter: CatsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//       businessService
        catsAdapter = CatsAdapter(this,ArrayList())
        CatsRecycle.adapter = catsAdapter
        CatsRecycle.layoutManager = GridLayoutManager(this,2)
        CatsRecycle.setHasFixedSize(false)

        catsAdapter.notifyDataSetChanged()
        catspresImpl.mainCats = this
        catspresImpl.getcatss(30)

    }

    override fun getMaincats(result: List<catts>) {
       Log.d("catsim",result.toString())
        catsAdapter.updatelist(result)
        Catsprogress.visibility = View.INVISIBLE
    }

}





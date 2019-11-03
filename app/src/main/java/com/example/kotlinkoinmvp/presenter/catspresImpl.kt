package com.example.kotlinkoinmvp.presenter

import com.example.ainfo.repo.CatsRepo
import com.example.kotlinkoinmvp.model.catts

class catspresImpl constructor(var catsRepo : CatsRepo)  : catspres {
 lateinit var mainCats: MainCats

    override fun catsimages(result: List<catts>) {
      mainCats.getMaincats(result)

    }
    init {
        catsRepo.topcats = this
    }
    fun getcatss( x : Int){
        catsRepo.getcats(x)


    }
}
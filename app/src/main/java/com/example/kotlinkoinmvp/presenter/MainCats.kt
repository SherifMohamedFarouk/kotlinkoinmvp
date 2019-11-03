package com.example.kotlinkoinmvp.presenter

import com.example.kotlinkoinmvp.model.catts

interface MainCats {
    fun getMaincats(result: List<catts>)
}
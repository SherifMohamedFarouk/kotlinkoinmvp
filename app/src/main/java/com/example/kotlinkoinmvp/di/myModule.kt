package com.example.kotlinkoinmvp.di

import com.example.ainfo.repo.CatsRepo
import com.example.kotlinkoinmvp.presenter.catspresImpl
import org.koin.dsl.module

val myModule = module {
//        single{ BusinessService() }
    single{ catspresImpl(CatsRepo()) }
//    single{ BusinessService().buss() }

}


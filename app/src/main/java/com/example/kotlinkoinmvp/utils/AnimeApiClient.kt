package com.example.ainfo.utils
import com.example.kotlinkoinmvp.model.catts
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface AnimeApiClient {
        @GET("images/search")
        fun getCats(@Query("limit") limit: Int): Observable<List<catts>>


        companion object {

            fun create(): AnimeApiClient {

                val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("$base_url/")
                    .build()

                return retrofit.create(AnimeApiClient::class.java)

            }
        }

    }

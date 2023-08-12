package com.pmdm.virgen.dogapi.data.data_network.retrofit

import com.pmdm.virgen.dogapi.data.data_network.service.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object InstanceRetrofit {

    private const val URL_BASE = "https://dog.ceo/api/breed/"

    //by lazy quiere decir que lo inicialiará automáticamente cuando sea referenciada la propiedad retrofitService
    val retrofitService : ApiService by lazy{
        getRetrofit().create(ApiService::class.java)
    }



    //Devuelve una instancia de retrofit
    private fun getRetrofit() : Retrofit  = Retrofit
            .Builder()
            .baseUrl(URL_BASE)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

}
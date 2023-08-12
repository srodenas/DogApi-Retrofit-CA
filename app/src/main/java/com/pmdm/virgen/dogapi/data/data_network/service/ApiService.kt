package com.pmdm.virgen.dogapi.data.data_network.service

import com.pmdm.virgen.dogapi.data.model.model_network.ResponseDog
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

/*
Contrato con la Api. Sólo tendremos una llamada GET

https://dog.ceo/api/breed/hound/images
url tendrá la forma    /{raza}/images
 */
interface ApiService {

    @GET
    suspend fun getDog(@Url url:String): Response<ResponseDog>
}


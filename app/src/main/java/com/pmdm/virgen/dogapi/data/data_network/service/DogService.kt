package com.pmdm.virgen.dogapi.data.data_network.service

import android.util.Log
import com.pmdm.virgen.dogapi.data.data_network.retrofit.InstanceRetrofit
import com.pmdm.virgen.dogapi.data.model.model_network.ResponseDog
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response


/*
Clase que se encargará de forma implícita de trabajar con Retrofit y devolver la respuesta
de la API.
El método getDog se ejecutará en un nuevo hilo, por tanto utiliamos Corrutinas.
 */
class DogService (var breed: String){

    //método que devuelve la respuesta de Retrofit.
    suspend fun getDogs(): ResponseDog ? {
        return withContext(Dispatchers.IO){
            //lanzamos la request
            val call : Response<ResponseDog> = InstanceRetrofit.retrofitService.getDog("$breed/images")
            if (!call.isSuccessful){
                showError()
            }
            call.body()
        }
    }

    private fun showError() {
        Log.i("TAG-ERROR", "Error en la llamada GET")
    }
}
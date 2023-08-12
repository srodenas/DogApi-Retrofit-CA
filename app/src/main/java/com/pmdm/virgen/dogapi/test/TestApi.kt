package com.pmdm.virgen.dogapi.test

import android.util.Log
import com.pmdm.virgen.dogapi.data.data_network.service.RepositotyApi

class TestApi {

    companion object {

        suspend fun testDogApi() {
            val breed = "maltese"
            val listDogs = RepositotyApi(breed).getDogs()

            if (listDogs.isNotEmpty()) {
                listDogs.forEach() {
                    Log.i("TAG-DOGS", it)
                }
            } else {
                Log.i("TAG-ERROR", "No hay perros para mostrar")
            }
        }
    }
}
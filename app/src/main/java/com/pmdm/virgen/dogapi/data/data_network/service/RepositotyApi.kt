package com.pmdm.virgen.dogapi.data.data_network.service

import com.pmdm.virgen.dogapi.data.model.Dog
import com.pmdm.virgen.dogapi.data.model.DogsRepository
import com.pmdm.virgen.dogapi.data.model.model_network.ResponseDog

class RepositotyApi (var breed: String ){

    private val dogService = DogService(breed)  //Servicio que se encarga de devolver la response

    /*
    Método que se encarga llamar al servicio y devolver una lista de Dogs
     */
    suspend fun getDogs(): List<String>{
        val response : ResponseDog ? = dogService.getDogs()
        response.let {
            DogsRepository.dogs = it!!.listDogs  //los cargo en memoria
        }
        return DogsRepository.dogs  //He cargado los perros y devuelvo la lista que me pide.
    }
}
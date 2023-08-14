package com.pmdm.virgen.dogapi.domain

import com.pmdm.virgen.dogapi.data.data_network.service.RepositotyApi

class GetDogsRepositoryUseCase {

    private lateinit var repository : RepositotyApi


   /*
   creo el repository con la raza a mostrar.
    */
   fun initRepository(breed: String) {
       repository  = RepositotyApi(breed)
   }

    /*
    Método que devuelve los datos.
     */
    suspend operator fun invoke(): List<String> ? = repository.getDogs()
}
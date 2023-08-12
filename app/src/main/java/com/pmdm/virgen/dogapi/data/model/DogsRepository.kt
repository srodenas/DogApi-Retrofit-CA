package com.pmdm.virgen.dogapi.data.model

/*
Lista de Dogs en memoria.
 */
class DogsRepository {

    companion object{
        var dogs: List<String> = emptyList()
    }
}
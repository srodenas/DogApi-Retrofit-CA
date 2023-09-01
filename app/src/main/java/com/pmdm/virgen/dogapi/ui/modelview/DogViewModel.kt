package com.pmdm.virgen.dogapi.ui.modelview

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pmdm.virgen.dogapi.domain.GetDogsRepositoryUseCase
import kotlinx.coroutines.launch

class DogViewModel : ViewModel() {
    var dogListLiveData = MutableLiveData<List<String>>()  //Creamos la lista a observar.
    var progressBarLiveData = MutableLiveData<Boolean>()  //para la barra de progreso.
    val getDogsRepositoryUseCase = GetDogsRepositoryUseCase()  //Creo el repositorio
    var search = MutableLiveData<String>() //para el campo search



    //Nos traemos los datos y los cargamos al inicialiar el objeto.
    init {
        viewModelScope.launch {
            progressBarLiveData.postValue(true)  //se ve.
            getDogsRepositoryUseCase.initRepository("maltese") //esto es superfeo, pero para ver como funciona.
            val result: List<String>? = getDogsRepositoryUseCase()
            result.let { myList ->
                dogListLiveData.postValue(myList)  //notificamos el cambio y el observer se enterará
                progressBarLiveData.postValue(false)
            }
        }
    }



    public fun searchByBreed(breed: String){
        search.postValue(breed)
    }

    public fun searchByBreedList(breed: String){
        viewModelScope.launch {
            progressBarLiveData.postValue(true)
            getDogsRepositoryUseCase.initRepository(breed) //esto es superfeo, pero para ver como funciona.
            val result: List<String>? = getDogsRepositoryUseCase()
            result.let { myList ->
                dogListLiveData.postValue(myList)  //notificamos el cambio y el observer se enterará
                progressBarLiveData.postValue(false)
            }
        }
    }

}
package com.pmdm.virgen.dogapi.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.pmdm.virgen.dogapi.R
import com.pmdm.virgen.dogapi.data.data_network.service.RepositotyApi
import com.pmdm.virgen.dogapi.data.model.model_network.ResponseDog
import com.pmdm.virgen.dogapi.databinding.ActivityMainBinding
import com.pmdm.virgen.dogapi.domain.GetDogsRepositoryUseCase
import com.pmdm.virgen.dogapi.test.TestApi
import com.pmdm.virgen.dogapi.ui.adapter.DogAdapter
import com.pmdm.virgen.dogapi.ui.modelview.DogViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        registerLiveData()
        init()  //inicializa la clase
       // testApiDog3()  //para el testeo de retrofit

    }


    private lateinit var adapter : DogAdapter
    private lateinit var binding : ActivityMainBinding
    private val dogViewModel : DogViewModel by viewModels()



    private fun registerLiveData() {
        dogViewModel.dogListLiveData.observe(
            this, {  myList->
                //Aquí hacemos la actualización del adapter.
                adapter.dogRepository = myList!!  //aseguro los datos.
                binding.myRecyclerPpal.adapter = adapter  //le asigno el adapter.
                adapter.notifyDataSetChanged()  //No hace falta, pero por si acaso.
            }
        )
    }


    /*
    0.- Inicializo el RecyclerView
    1.- Creo el adapter
    2.- Llamo al caso de uso pasándole como ejemplo maltese
    3.- lanzo la corrutina con la devolución de los datos.
    4.- asigno el adapter al recycler view.
     */
    private fun init(){
        initRecyclerView()
        adapter = DogAdapter()
    }




    private fun initRecyclerView() {
        binding.myRecyclerPpal.layoutManager = LinearLayoutManager(this)

    }










    //Test de pruebas de que funciona la petición a Retrofit
    private fun testApiDog3() {
        lifecycleScope.launch {
            TestApi.testDogApi()
        }
    }



}
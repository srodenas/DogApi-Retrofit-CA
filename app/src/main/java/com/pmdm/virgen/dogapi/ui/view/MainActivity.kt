package com.pmdm.virgen.dogapi.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.activity.viewModels
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.pmdm.virgen.dogapi.databinding.ActivityMainBinding
import com.pmdm.virgen.dogapi.test.TestApi
import com.pmdm.virgen.dogapi.ui.adapter.DogAdapter
import com.pmdm.virgen.dogapi.ui.modelview.DogViewModel
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(), SearchView.OnQueryTextListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.mySearch.setOnQueryTextListener(this)
        registerLiveData()
        init()  //inicializa la clase
       // testApiDog3()  //para el testeo de retrofit

    }


    private lateinit var adapter : DogAdapter
    private lateinit var binding : ActivityMainBinding
    private val dogViewModel : DogViewModel by viewModels()


    /*
    Supuestamente, se llamará cuando cambie la lista de datos.
     */
    private fun registerLiveData() {
        dogViewModel.dogListLiveData.observe(
            this, {  myList->
                //Aquí hacemos la actualización del adapter.
                adapter.dogRepository = myList!!  //aseguro los datos.
                binding.myRecyclerPpal.adapter = adapter  //le asigno el adapter.
                adapter.notifyDataSetChanged()  //No hace falta, pero por si acaso.
            }
        )

        dogViewModel.progressBarLiveData.observe(
            this, { visible ->
                binding.progressBar.isVisible = visible
            }
        )

        //observo cualquier cambio en el componente search
        dogViewModel.search.observe(
            this, {  breed->
                searchByBreed(breed)  //ordeno cargar los datos.
            }
        )
    }


    /*
    método que hace que se carguen los nuevos datos por raza y se modificará
    el observable dogListLiveData
     */
    private fun searchByBreed(breed: String?) {
        dogViewModel.searchByBreedList(breed!!)
        hideKeyBoard()
    }



    private fun hideKeyBoard() {
        val imn = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imn.hideSoftInputFromWindow(binding.myLayoutPpal.windowToken, 0)
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


    /*
    Si el texto que escribimos en el campo my_search no es nulo y vacío, tenemos que llamar al método que
    nos cargue todas las imágenes por texto introducido.
     */
    override fun onQueryTextSubmit(query: String?): Boolean {

        if (!query.isNullOrEmpty())
            dogViewModel.searchByBreed(query!!)
        return true
    }


    /*
    Cualquier cambio, llamará a este método. Estoy obligado a ponerlo
     */
    override fun onQueryTextChange(newText: String?): Boolean {
        return true
    }


}
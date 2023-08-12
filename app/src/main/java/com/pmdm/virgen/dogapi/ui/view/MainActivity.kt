package com.pmdm.virgen.dogapi.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.pmdm.virgen.dogapi.R
import com.pmdm.virgen.dogapi.data.data_network.service.RepositotyApi
import com.pmdm.virgen.dogapi.data.model.model_network.ResponseDog
import com.pmdm.virgen.dogapi.test.TestApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        testApiDog3()

    }

    //Test de pruebas de que funciona la petición a Retrofit
    private fun testApiDog3() {
        lifecycleScope.launch {
            TestApi.testDogApi()
        }
    }










    /*
    private fun testApiDog2(){
        lifecycleScope.launch{
            val breed = "maltese"
            val listDogs =  RepositotyApi(breed).getDogs()
            if (listDogs.isNotEmpty()){
                listDogs.forEach(){
                    Log.i("TAG-DOGS", it)
                }
            }else{
                Log.i("TAG-ERROR", "No hay perros para mostrar")
            }
        }
    }


    private fun testApiDog1() {
        lifecycleScope.launch {
            val breed = "maltese"
            val call: Response<ResponseDog> =
                InstanceRetrofit.retrofitService.getDog("$breed/images")
            if (call.isSuccessful) {
                val data: ResponseDog? = call.body()
                if (data != null) {
                    data.listDogs.let { list ->
                        list.forEach() {
                            Log.i("TAG-DOGS", it)
                        }
                    }
                }
            } else {
                Log.i("TAG-ERROR", "No hay perros para mostrar")
            }
        }
    }

    private fun testApiDog() {
        CoroutineScope(Dispatchers.IO).launch {
            val breed = "maltese"
            val call : Response<ResponseDog> = InstanceRetrofit.retrofitService.getDog("$breed/images")
            if (call.isSuccessful){
                val data : ResponseDog? = call.body()
                if (data != null) {
                    data.listDogs.let { list ->
                        list.forEach() {
                            Log.i("TAG-DOGS", it)
                        }
                    }
                }
            }else{
                Log.i("TAG-ERROR", "No hay perros para mostrar")
            }
        }
    }

*/



}
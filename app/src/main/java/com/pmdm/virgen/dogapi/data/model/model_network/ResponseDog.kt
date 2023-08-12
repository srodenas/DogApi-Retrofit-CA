package com.pmdm.virgen.dogapi.data.model.model_network

import com.google.gson.annotations.SerializedName



class ResponseDog(
    @SerializedName ("message") var listDogs : List<String>,
    @SerializedName ("status") var status : String
) {


}

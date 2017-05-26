package com.example.agdu.exampleapp.api.pojo.weather

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



/**
 * @author Agnieszka Dulęba <agnieszka.duleba@ailleron.pl>
 * @since 2017-05-26
 */

class Coord {

    @SerializedName("lon")
    @Expose
    var lon: Double? = null
    @SerializedName("lat")
    @Expose
    var lat: Double? = null

}
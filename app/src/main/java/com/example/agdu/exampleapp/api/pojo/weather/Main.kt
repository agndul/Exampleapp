package com.example.agdu.exampleapp.api.pojo.weather

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



/**
 * @author Agnieszka Dulęba <agnieszka.duleba@ailleron.pl>
 * @since 2017-05-26
 */
class Main {

    @SerializedName("temp")
    @Expose
    var temp: Double? = null
    @SerializedName("pressure")
    @Expose
    var pressure: Int? = null
    @SerializedName("humidity")
    @Expose
    var humidity: Int? = null
    @SerializedName("temp_min")
    @Expose
    var tempMin: Double? = null
    @SerializedName("temp_max")
    @Expose
    var tempMax: Double? = null

}
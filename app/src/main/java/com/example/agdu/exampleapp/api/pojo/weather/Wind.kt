package com.example.agdu.exampleapp.api.pojo.weather

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



/**
 * @author Agnieszka Dulęba <agnieszka.duleba@ailleron.pl>
 * @since 2017-05-26
 */
class Wind {

    @SerializedName("speed")
    @Expose
    var speed: Double? = null
    @SerializedName("deg")
    @Expose
    var deg: Int? = null

}
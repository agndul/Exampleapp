package com.example.agdu.exampleapp.api.pojo.weather

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



/**
 * @author Agnieszka Dulęba <agnieszka.duleba@ailleron.pl>
 * @since 2017-05-26
 */
class Sys {

    @SerializedName("type")
    @Expose
    var type: Int? = null
    @SerializedName("id")
    @Expose
    var id: Int? = null
    @SerializedName("message")
    @Expose
    var message: Double? = null
    @SerializedName("country")
    @Expose
    var country: String? = null
    @SerializedName("sunrise")
    @Expose
    var sunrise: Int? = null
    @SerializedName("sunset")
    @Expose
    var sunset: Int? = null

}
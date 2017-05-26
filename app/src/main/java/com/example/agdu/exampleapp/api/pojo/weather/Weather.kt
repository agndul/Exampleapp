package com.example.agdu.exampleapp.api.pojo.weather

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



/**
 * @author Agnieszka Dulęba <agnieszka.duleba@ailleron.pl>
 * @since 2017-05-26
 */

class Weather {

    @SerializedName("id")
    @Expose
    var id: Int? = null
    @SerializedName("main")
    @Expose
    var main: String? = null
    @SerializedName("description")
    @Expose
    var description: String? = null
    @SerializedName("icon")
    @Expose
    var icon: String? = null

}
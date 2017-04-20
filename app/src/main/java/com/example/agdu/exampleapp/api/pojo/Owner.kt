package com.example.agdu.exampleapp.api.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by agdu on 2017-04-19.
 */

class Owner {

    @SerializedName("reputation")
    @Expose
    var reputation: Int? = null
    @SerializedName("user_id")
    @Expose
    var userId: Int? = null
    @SerializedName("user_type")
    @Expose
    var userType: String? = null
    @SerializedName("profile_image")
    @Expose
    var profileImage: String? = null
    @SerializedName("display_name")
    @Expose
    var displayName: String? = null
    @SerializedName("link")
    @Expose
    var link: String? = null
    @SerializedName("accept_rate")
    @Expose
    var acceptRate: Int? = null

}
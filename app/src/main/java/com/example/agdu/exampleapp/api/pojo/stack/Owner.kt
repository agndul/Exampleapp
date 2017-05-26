package com.example.agdu.exampleapp.api.pojo.stack

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by agdu on 2017-04-19.
 */

class Owner {

    @com.google.gson.annotations.SerializedName("reputation")
    @com.google.gson.annotations.Expose
    var reputation: Int? = null
    @com.google.gson.annotations.SerializedName("user_id")
    @com.google.gson.annotations.Expose
    var userId: Int? = null
    @com.google.gson.annotations.SerializedName("user_type")
    @com.google.gson.annotations.Expose
    var userType: String? = null
    @com.google.gson.annotations.SerializedName("profile_image")
    @com.google.gson.annotations.Expose
    var profileImage: String? = null
    @com.google.gson.annotations.SerializedName("display_name")
    @com.google.gson.annotations.Expose
    var displayName: String? = null
    @com.google.gson.annotations.SerializedName("link")
    @com.google.gson.annotations.Expose
    var link: String? = null
    @com.google.gson.annotations.SerializedName("accept_rate")
    @com.google.gson.annotations.Expose
    var acceptRate: Int? = null

}
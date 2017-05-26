package com.example.agdu.exampleapp.api.pojo.stack

/**
 * Created by agdu on 2017-04-19.
 */

class ExampleResponse {

    @com.google.gson.annotations.SerializedName("items")
    @com.google.gson.annotations.Expose
    var items: List<Item>? = null
    @com.google.gson.annotations.SerializedName("has_more")
    @com.google.gson.annotations.Expose
    var hasMore: Boolean? = null
    @com.google.gson.annotations.SerializedName("quota_max")
    @com.google.gson.annotations.Expose
    var quotaMax: Int? = null
    @com.google.gson.annotations.SerializedName("quota_remaining")
    @com.google.gson.annotations.Expose
    var quotaRemaining: Int? = null

}
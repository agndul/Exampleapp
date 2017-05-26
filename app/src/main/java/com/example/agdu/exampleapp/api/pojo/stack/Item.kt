package com.example.agdu.exampleapp.api.pojo.stack

/**
 * Created by agdu on 2017-04-19.
 */

class Item {

    @com.google.gson.annotations.SerializedName("owner")
    @com.google.gson.annotations.Expose
    var owner: Owner? = null
    @com.google.gson.annotations.SerializedName("is_accepted")
    @com.google.gson.annotations.Expose
    var isAccepted: Boolean? = null
    @com.google.gson.annotations.SerializedName("score")
    @com.google.gson.annotations.Expose
    var score: Int? = null
    @com.google.gson.annotations.SerializedName("last_activity_date")
    @com.google.gson.annotations.Expose
    var lastActivityDate: Int? = null
    @com.google.gson.annotations.SerializedName("creation_date")
    @com.google.gson.annotations.Expose
    var creationDate: Int? = null
    @com.google.gson.annotations.SerializedName("answer_id")
    @com.google.gson.annotations.Expose
    var answerId: Int? = null
    @com.google.gson.annotations.SerializedName("question_id")
    @com.google.gson.annotations.Expose
    var questionId: Int? = null
    @com.google.gson.annotations.SerializedName("last_edit_date")
    @com.google.gson.annotations.Expose
    var lastEditDate: Int? = null

    class DisplayNameComparator : java.util.Comparator<Item> {
        override fun compare(o1: com.example.agdu.exampleapp.api.pojo.stack.Item?, o2: com.example.agdu.exampleapp.api.pojo.stack.Item?): Int {
            return (o1!!.owner!!.displayName!!.toLowerCase().compareTo(o2!!.owner!!.displayName!!.toLowerCase()))
        }
    }
}
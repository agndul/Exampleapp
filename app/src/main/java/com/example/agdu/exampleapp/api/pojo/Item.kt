package com.example.agdu.exampleapp.api.pojo

/**
 * Created by agdu on 2017-04-19.
 */

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.Comparator

class Item {

    @SerializedName("owner")
    @Expose
    var owner: Owner? = null
    @SerializedName("is_accepted")
    @Expose
    var isAccepted: Boolean? = null
    @SerializedName("score")
    @Expose
    var score: Int? = null
    @SerializedName("last_activity_date")
    @Expose
    var lastActivityDate: Int? = null
    @SerializedName("creation_date")
    @Expose
    var creationDate: Int? = null
    @SerializedName("answer_id")
    @Expose
    var answerId: Int? = null
    @SerializedName("question_id")
    @Expose
    var questionId: Int? = null
    @SerializedName("last_edit_date")
    @Expose
    var lastEditDate: Int? = null

    class DisplayNameComparator : Comparator<Item> {
        override fun compare(o1: Item?, o2: Item?): Int {
            return (o1!!.owner!!.displayName!!.toLowerCase().compareTo(o2!!.owner!!.displayName!!.toLowerCase()))
        }
    }
}
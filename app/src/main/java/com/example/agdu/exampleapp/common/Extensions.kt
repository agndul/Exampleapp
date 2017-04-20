@file:JvmName("ExtensionsUtils")

package com.example.agdu.exampleapp.common

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by agdu on 2017-04-20.
 */

    fun ViewGroup.inflate(layoutId: Int, attach: Boolean = false): View? {
        return LayoutInflater.from(context).inflate(layoutId, this, attach)
    }

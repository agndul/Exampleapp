package com.example.agdu.exampleapp.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.agdu.exampleapp.R
import com.example.agdu.exampleapp.common.inflate
import com.jakewharton.rxbinding2.view.RxView
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.fragment_main.*
import java.util.concurrent.TimeUnit

/**
 * Created by agdu on 2017-04-20.
 */
class MainFragment: Fragment() {

    companion object{
        const val LIST_POSITION = "list_position"
        const val LIST_VALUE = "list_value"

        fun newInstance(pos: Int, value: String): MainFragment {
            val fragment: MainFragment = MainFragment()
            val bundle: Bundle = Bundle()
            bundle.putInt(LIST_POSITION, pos)
            bundle.putString(LIST_VALUE, value)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return container!!.inflate(R.layout.fragment_main)!!
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val value = arguments!!.getString(LIST_VALUE)
        tv_display.text = "onActivityCreated, selected value: " + value

        RxView.clicks(progressBar)
                .debounce(1500, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe{
                    progressBar.visibility = View.GONE
                }
    }
}
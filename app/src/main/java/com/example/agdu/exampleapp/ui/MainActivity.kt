package com.example.agdu.exampleapp.ui

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import com.example.agdu.exampleapp.R
import com.example.agdu.exampleapp.api.WeatherApi.Companion.weatherApiInstance
import com.example.agdu.exampleapp.api.pojo.stack.WeatherService
import com.jakewharton.rxbinding2.view.RxView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import java.net.HttpURLConnection
import java.util.concurrent.TimeUnit


class MainActivity : AppCompatActivity(), RvAdapter.onViewClickedListener {
    override fun onItemClicked(pos: Int) {
        changeFragment(MainFragment.newInstance(pos, list[pos]))
    }

    val apiKey = "b1b15e88fa797225412429c1c50c122a1"
    val rvAdapter = RvAdapter(this)
    val list: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRv()
        initAdapter()
        //val stackService = retrofitInstance().create(StackService::class.java)
        val weatherService = weatherApiInstance().create(WeatherService::class.java)

        RxView.clicks(btn_click)
                .debounce(1000, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    btn_click.text = getString(R.string.btn_loading)

                    weatherService.getWeather("Krakow", apiKey)
                            .subscribeOn(Schedulers.newThread())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe({
                                list.add(it.code().toString())
                                rvAdapter.addData(list)
                            }, {
                                btn_click.text = getString(R.string.btn_error)
                            }, {
                                btn_click.text = getString(R.string.btn_finished)
                            })

                }

    }

    override fun onBackPressed() {
        super.onBackPressed()
        showFragment(false)

    }

    fun initRv(): Unit {
        rv_list.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            clearOnScrollListeners()
        }
    }

    private fun initAdapter() {
        if (rv_list.adapter == null) {
            rv_list.adapter = rvAdapter
        }
    }

    fun changeFragment(f: Fragment) {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.activity_base_content, f)
                .addToBackStack(null)
                .commit()
        showFragment()
    }

    fun showFragment(isVisible: Boolean = true) {
        //todo: fix, refactor, make it better?
        activity_base_content.visibility = if (isVisible) View.VISIBLE else View.GONE
        rv_list.visibility = if (isVisible) View.GONE else View.VISIBLE
        btn_click.visibility = if (isVisible) View.GONE else View.VISIBLE
    }

    fun showFilteredList(intent: Intent?) {

        Log.e("Log", "Act res hm hm hm")
        Log.e("Log", "Act res" + intent?.extras?.getString("date"))
        // showFragment(false)
    }
}


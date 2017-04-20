package com.example.agdu.exampleapp.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.example.agdu.exampleapp.R
import com.example.agdu.exampleapp.api.RestApi.Companion.retrofitInstance
import com.example.agdu.exampleapp.api.pojo.ExampleResponse
import com.example.agdu.exampleapp.api.pojo.Item
import com.example.agdu.exampleapp.api.pojo.StackService
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    val rvAdapter = RvAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRv()
        initAdapter()

        val stackService = retrofitInstance().create(StackService::class.java)
        val stackResponse: Observable<ExampleResponse> = stackService.getAnswers()

        stackResponse
                .subscribeOn(Schedulers.newThread())
                .concatMap { items -> Observable.fromArray(items.items) }
                .map{it ->
                    var sorted: List<Item>? = it
               //    Collections.sort(sorted, Item.DisplayNameComparator())
                    sorted = sorted!!.sortedWith(Item.DisplayNameComparator())
                    sorted
                }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    it!!.forEach {
                        rvAdapter.addSingleElement(it.owner!!.displayName!!)
                        Log.e("Changed displayname", it.owner?.displayName)
                    }
               }

    }

    fun initRv(): Unit{
        rv_list.apply {
            setHasFixedSize(true)
            val linearLayout = LinearLayoutManager(context)
            layoutManager = linearLayout
        }
    }

    private fun initAdapter() {
        if (rv_list.adapter == null) {
            rv_list.adapter = rvAdapter
        }
    }
}


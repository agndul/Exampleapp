package com.example.agdu.exampleapp.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import com.example.agdu.exampleapp.R
import com.example.agdu.exampleapp.api.RestApi.Companion.retrofitInstance
import com.example.agdu.exampleapp.api.pojo.Item
import com.example.agdu.exampleapp.api.pojo.StackService
import com.jakewharton.rxbinding2.view.RxView
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.TimeUnit


class MainActivity : AppCompatActivity(), RvAdapter.onViewClickedListener {
    override fun onItemClicked(pos: Int) {
        changeFragment(MainFragment.newInstance(pos, list[pos]))
        showFragment()
    }

    val rvAdapter = RvAdapter(this)
    val list: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRv()
        initAdapter()
        val stackService = retrofitInstance().create(StackService::class.java)

        RxView.clicks(btn_click)
                .debounce(1000, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe{
                    btn_click.text = getString(R.string.btn_loading)
                    stackService.getAnswers()
                            .subscribeOn(Schedulers.newThread())
                            .concatMap { items -> Observable.fromArray(items.items) }
                            .map { it ->
                                var sorted: List<Item>? = it
                                sorted = sorted!!.sortedWith(Item.DisplayNameComparator())
                                sorted
                            }
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe( {
                                it!!.forEach {
                                    list.add(it.owner?.displayName!!)
                                    Log.e("Changed displayname", it.owner?.displayName)
                                }
                                rvAdapter.addData(list)

                            }, {
                                btn_click.text = getString(R.string.btn_error)
                            }, {
                                btn_click.text = getString(R.string.btn_finished)
                            } )

                    }

    }

    override fun onBackPressed() {
        super.onBackPressed()
        showFragment(false)

    }

    fun initRv(): Unit{
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
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.activity_base_content, f)
        ft.addToBackStack(null)
        ft.commit()
    }

    fun showFragment(isVisible: Boolean=true){
        activity_base_content.visibility = if(isVisible) View.VISIBLE else View.GONE
        rv_list.visibility = if(isVisible) View.GONE else View.VISIBLE
        btn_click.visibility = if(isVisible) View.GONE else View.VISIBLE
    }
}


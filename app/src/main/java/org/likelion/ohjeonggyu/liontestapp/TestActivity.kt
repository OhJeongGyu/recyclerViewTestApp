package org.likelion.ohjeonggyu.liontestapp

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.View

class TestActivity : AppCompatActivity() {


    private val recyclerView: RecyclerView by lazy {
        findViewById(R.id.recyclerView) as RecyclerView
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        init()
    }

    private fun init() {
        val adapter: UserRecyclerAdapter = UserRecyclerAdapter(this)
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@TestActivity)
            setAdapter(adapter)
            setHasFixedSize(true)
        }
        adapter.addUsers(UserModel.users)
    }

}

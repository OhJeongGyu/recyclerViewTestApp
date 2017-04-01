package org.likelion.ohjeonggyu.liontestapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById(R.id.button).setOnClickListener {
            val intent: Intent = Intent(this, TestActivity::class.java)
            startActivity(intent)
        }

    }



}

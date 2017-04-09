package org.likelion.ohjeonggyu.liontestapp

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import network.FlickrService
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.Result
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class TestActivity : AppCompatActivity() {

    private val BASE_URL = "https://api.flickr.com/"
    private val METHOD = "flickr.photos.getRecent"
    private val API_KEY = "<API_KEY>"
    private val FORMAT = "json"

    private val recyclerView: RecyclerView by lazy {
        findViewById(R.id.recyclerView) as RecyclerView
    }

    private val imageView: ImageView by lazy {
        findViewById(R.id.imageView) as ImageView
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
//        init()

        foo()
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


    private fun foo(){

        Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
                .create(FlickrService::class.java)
                .getRecentImage(METHOD, API_KEY, FORMAT, 1, 1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                        it ->
                        var photo = it.photos.photo[0]
                        Glide.with(this)
                                .load("http://farm${photo.farm}.staticflickr.com/${photo.server}/${photo.id}_${photo.secret}.jpg")
                                .centerCrop()
                                .into(imageView)


                    },{
                        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                    },{
                        Toast.makeText(this, "Complete", Toast.LENGTH_SHORT).show()
                    })




    }


}

package com.moeiny.reza.deloittest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.moeiny.reza.deloittest.view.adapter.PhotoAdapter
import com.moeiny.reza.deloittest.repository.database.entitiy.PhotoEntity
import com.moeiny.reza.deloittest.view.androidviewmodel.PhotoShow
import com.moeiny.reza.deloittest.view.androidviewmodel.PhotosViewModel
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    lateinit var photoList:ArrayList<PhotoEntity>
    lateinit var showList:ArrayList<PhotoShow>
    lateinit var recyclerView: RecyclerView

    lateinit var viewModel: PhotosViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        photoList = ArrayList<PhotoEntity>()
        showList = ArrayList<PhotoShow>()
        setUpView()
        photoList=viewModel.getAllPhoto() as ArrayList<PhotoEntity>
        loadData()
    }

    fun loadData(){
        showList.clear()
        for ( i in 0..photoList.size-1){
            var show= PhotoShow(
                photoList[i].owner,
                photoList[i].url,
                photoList[i].title
            )
            showList.add(show)
        }

        setDataOnRecycler(showList)
    }

    fun setDataOnRecycler(showList:List<PhotoShow>) {
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = PhotoAdapter(this,showList)
    }

    fun setUpView() {
        viewModel = ViewModelProviders.of(this).get(PhotosViewModel::class.java)
        recyclerView = findViewById(R.id.rv_main_lastnews)
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

}

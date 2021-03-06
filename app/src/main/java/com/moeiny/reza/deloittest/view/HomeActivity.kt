package com.moeiny.reza.deloittest.view

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.lifecycle.ViewModelProviders
import com.moeiny.reza.deloittest.MainActivity
import com.moeiny.reza.deloittest.R
import com.moeiny.reza.deloittest.view.androidviewmodel.PhotosViewModel


class HomeActivity : AppCompatActivity() {
    lateinit var viewModel: PhotosViewModel

    lateinit var txt_Continue: TextView
    lateinit var rl_loading: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setContext(this)
        viewModel = ViewModelProviders.of(this).get(PhotosViewModel::class.java)


        txt_Continue = findViewById(R.id.txt_home_continue)
        rl_loading = findViewById(R.id.loadingPanel)

        txt_Continue.setOnClickListener {
            setView(rl_loading)
            txt_Continue.text = "Loading..."
            rl_loading.visibility= View.VISIBLE
            viewModel.getPhotos()
        }
    }

    companion object {
        private lateinit var context:Context

        private lateinit var view: ProgressBar

        fun getView(): ProgressBar { return this.view}
        fun setView(view : ProgressBar) { this.view=view }

        fun setContext(context:Context){
           this.context=context
        }

        fun move(){
            val intent = Intent(context, MainActivity::class.java)
            context.startActivity(intent)
        }

    }






}

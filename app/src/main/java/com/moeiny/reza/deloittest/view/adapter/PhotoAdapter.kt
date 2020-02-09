package com.moeiny.reza.deloittest.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.moeiny.reza.deloittest.databinding.PhotoBinding
import com.moeiny.reza.deloittest.utils.CustomClickListener
import com.moeiny.reza.deloittest.view.androidviewmodel.PhotoShow


class PhotoAdapter(var context: Context, var photoList:List<PhotoShow>): RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder>() ,
    CustomClickListener {

       override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val photoBinding = PhotoBinding.inflate(layoutInflater, parent, false)
        return PhotoViewHolder(photoBinding)
    }

    override fun getItemCount(): Int {
        return photoList.count()
    }

    override fun onBindViewHolder(holderPhoto: PhotoViewHolder, position: Int) {
        var photo=photoList.get(position)

        holderPhoto.bind(photo)
        holderPhoto.photoBinding.setItemClickListener(this)
    }

    inner class PhotoViewHolder(val photoBinding: PhotoBinding): RecyclerView.ViewHolder(photoBinding.root){
      fun bind(modelView: PhotoShow) {
          this.photoBinding.showPhoto = modelView
      }
    }

    override fun cardClicked(photo: PhotoShow) {

       }

    @BindingAdapter("imageUrl")
    fun ImageView.setImageUrl(url: String?) {
        Glide.with(context).load(url).into(this)
    }

}
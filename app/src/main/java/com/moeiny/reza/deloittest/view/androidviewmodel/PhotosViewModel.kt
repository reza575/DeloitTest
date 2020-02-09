package com.moeiny.reza.deloittest.view.androidviewmodel

import android.app.Application
import android.view.View
import androidx.lifecycle.AndroidViewModel
import com.moeiny.reza.deloittest.repository.database.entitiy.PhotoEntity
import com.moeiny.reza.deloittest.repository.database.entitiy.PhotosEntity
import com.moeiny.reza.deloittest.repository.database.repository.PhotosRepository
import com.moeiny.reza.deloittest.repository.model.Photo
import com.moeiny.reza.deloittest.repository.model.PhotoPack
import com.moeiny.reza.deloittest.viewModel.PhotoService
import com.moeiny.reza.deloittest.utils.DeloitCallback
import com.moeiny.reza.deloittest.view.HomeActivity
import java.util.concurrent.CountDownLatch

class PhotosViewModel(application: Application) : AndroidViewModel(application) {

    private  var photosRepository: PhotosRepository
    private  var allPhotosData:List<PhotosEntity>
    private  var allPhotoData:List<PhotoEntity>


    init {
        photosRepository= PhotosRepository(application)
        allPhotosData=photosRepository.getAllPhotos()
        allPhotoData=photosRepository.getAllPhoto()
    }


    fun insert(photosEntity: PhotosEntity){
        photosRepository.insertPhotos(photosEntity)
    }

    fun update(photosEntity: PhotosEntity){
        photosRepository.updatePhotos(photosEntity)
    }

    fun delete(photosEntity: PhotosEntity){
        photosRepository.deletePhotos(photosEntity)
    }

    fun deleteAllPhotos(){
        photosRepository.deleteAllPhotos()
    }

    fun getPhotosBypageNo(page_no: Int):List<PhotosEntity>{
        return photosRepository.getPhotosbypageNo(page_no)
    }

    fun getAllPhotos():List<PhotosEntity>{
        return allPhotosData
    }

    //////////////////////////////////////////////////

    fun insert(photoEntity: PhotoEntity){
        photosRepository.insertPhoto(photoEntity)
    }

    fun update(photoEntity: PhotoEntity){
        photosRepository.updatePhoto(photoEntity)
    }

    fun delete(photoEntity: PhotoEntity){
        photosRepository.deletePhoto(photoEntity)
    }

    fun deleteAllPhoto(){
        photosRepository.deleteAllPhoto()
    }

    fun getPhotoById(id: String):PhotoEntity{
        return photosRepository.getPhotobyId(id)
    }

    fun getAllPhoto():List<PhotoEntity>{
        return allPhotoData
    }

/////////////////////////////////////////////////////////////

fun getPhotos(){

       lateinit var PhotoList:ArrayList<Photo>
       lateinit var photosPack:PhotoPack
       val lock =  CountDownLatch(1)

    PhotoService.getPhotoPackInfo(object : DeloitCallback<PhotoPack, Throwable> {

            override fun onSuccess(result: PhotoPack) {
                lock.countDown()
                PhotoList = ArrayList<Photo>()
                photosPack = result

                var photos = PhotosEntity(photosPack.photos.page, photosPack.photos.pages, photosPack.photos.perpage,
                    photosPack.photos.total)
                insert(photos)

                PhotoList=photosPack.photos.photo as ArrayList<Photo>
                for(i in 0..PhotoList.size-1) {
                    var url=makeUrl(PhotoList[i].farm,PhotoList[i].server,PhotoList[i].id,PhotoList[i].secret)
                    var photo = PhotoEntity(PhotoList[i].id, PhotoList[i].owner, PhotoList[i].secret,
                        url, PhotoList[i].server, PhotoList[i].farm, PhotoList[i].title,
                        PhotoList[i].ispublic, PhotoList[i].isfriend, PhotoList[i].isfamily)

                    if (getPhotoById(PhotoList[i].id) == null)
                        insert(photo)
                }
            }

            override fun onError(error: Throwable?) {
                lock.countDown()
            }

            override fun onComplete() {
                lock.countDown()
                print("complete")
                var view= HomeActivity.getView()
                view.visibility= View.INVISIBLE
                HomeActivity.move()
            }
        })
    }

    fun makeUrl(farm:Int,server:String,id:String,secret:String):String{
        return ("https://farm"+farm+".static.flickr.com/"+server+"/"+id+"_"+secret+".jpg")
   //     http://farm{farm}.static.flickr.com/{server}/{id}_{secret}.jpg
    }

 }
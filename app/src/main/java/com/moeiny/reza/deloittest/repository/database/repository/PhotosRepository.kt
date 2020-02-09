package com.moeiny.reza.deloittest.repository.database.repository

import android.app.Application
import android.os.AsyncTask
import com.moeiny.reza.deloittest.repository.database.AppDatabase
import com.moeiny.reza.deloittest.repository.database.dao.PhotoDao
import com.moeiny.reza.deloittest.repository.database.dao.PhotosDao
import com.moeiny.reza.deloittest.repository.database.entitiy.PhotoEntity
import com.moeiny.reza.deloittest.repository.database.entitiy.PhotosEntity


class PhotosRepository(application: Application){

    private  var photosDao: PhotosDao
    private  var photoDao: PhotoDao


    private  var allPhotosData:List<PhotosEntity>
    private  var allPhotoData:List<PhotoEntity>


    init {
        val db: AppDatabase = AppDatabase.getInstance(
                application.applicationContext )!!

        photosDao = db.PhotosDao()
        photoDao = db.PhotoDao()

        allPhotosData = photosDao.getAll()
        allPhotoData = photoDao.getAll()

    }

    ////////////////////////////////Photos////////////////////////////

    fun insertPhotos(photosEntity: PhotosEntity){
        PhotosInsert(photosDao).execute(photosEntity)
    }

    fun updatePhotos(photosEntity: PhotosEntity){
        PhotosUpdate(photosDao).execute(photosEntity)
    }

    fun deletePhotos(photosEntity: PhotosEntity){
        PhotosDelete(photosDao).execute(photosEntity)
    }

    fun deleteAllPhotos(){
        photosDao.deleteAll()
    }

    fun getAllPhotos():List<PhotosEntity>{
        return allPhotosData
    }

    fun getPhotosbypageNo(page_no:Int):List<PhotosEntity>{
        return photosDao.findByPageNo(page_no)
    }



    private class PhotosInsert(photosDao: PhotosDao): AsyncTask<PhotosEntity, Void, Void>(){

        private var photosDao: PhotosDao
        init{
            this.photosDao=photosDao
        }

        override fun doInBackground(vararg p0: PhotosEntity): Void? {
            photosDao.insert(p0[0])
            return null
        }

    }

    private class PhotosUpdate(photosDao: PhotosDao): AsyncTask<PhotosEntity, Void, Void>(){

        private var photosDao:PhotosDao
        init{
            this.photosDao=photosDao
        }

        override fun doInBackground(vararg p0: PhotosEntity): Void? {
            photosDao.update(p0[0])
            return null
        }
    }

    private class PhotosDelete(photosDao: PhotosDao): AsyncTask<PhotosEntity, Void, Void>(){

        private var photosDao:PhotosDao
        init{
            this.photosDao=photosDao
        }

        override fun doInBackground(vararg p0: PhotosEntity): Void? {
            photosDao.delete(p0[0])
            return null
        }
    }

    ///////////////////////////Photo/////////////////////

    fun insertPhoto(photoEntity: PhotoEntity){
        PhotoInsert(photoDao).execute(photoEntity)
    }

    fun updatePhoto(photoEntity: PhotoEntity){
        PhotoUpdate(photoDao).execute(photoEntity)
    }

    fun deletePhoto(photoEntity: PhotoEntity){
        PhotoDelete(photoDao).execute(photoEntity)
    }

    fun deleteAllPhoto(){
        photoDao.deleteAll()
    }

    fun getAllPhoto():List<PhotoEntity>{
        return allPhotoData
    }

    fun getPhotobyId(photo_id:String):PhotoEntity{
        return photoDao.findByid(photo_id)
    }



    private class PhotoInsert(photoDao: PhotoDao): AsyncTask<PhotoEntity, Void, Void>(){

        private var photoDao: PhotoDao
        init{
            this.photoDao=photoDao
        }

        override fun doInBackground(vararg p0: PhotoEntity): Void? {
            photoDao.insert(p0[0])
            return null
        }

    }

    private class PhotoUpdate(photoDao: PhotoDao): AsyncTask<PhotoEntity, Void, Void>(){

        private var photoDao:PhotoDao
        init{
            this.photoDao=photoDao
        }

        override fun doInBackground(vararg p0: PhotoEntity): Void? {
            photoDao.update(p0[0])
            return null
        }
    }

    private class PhotoDelete(photoDao: PhotoDao): AsyncTask<PhotoEntity, Void, Void>(){

        private var photoDao:PhotoDao
        init{
            this.photoDao=photoDao
        }

        override fun doInBackground(vararg p0: PhotoEntity): Void? {
            photoDao.delete(p0[0])
            return null
        }
    }
}





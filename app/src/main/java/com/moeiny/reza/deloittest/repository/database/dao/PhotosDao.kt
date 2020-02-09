package com.moeiny.reza.deloittest.repository.database.dao

import androidx.room.*
import com.moeiny.reza.deloittest.repository.database.entitiy.PhotosEntity

@Dao
interface PhotosDao {

    @Query("SELECT * FROM Photos ")
    fun getAll(): List<PhotosEntity>

    @Query("SELECT * FROM Photos WHERE page = :page_no ")
    fun findByPageNo(page_no: Int): List<PhotosEntity>

    @Query("DELETE FROM Photos")
    fun deleteAll()

    @Insert
    fun insert(photos: PhotosEntity)

    @Update
    fun update(photos: PhotosEntity)

    @Delete
    fun delete(photos: PhotosEntity)
}





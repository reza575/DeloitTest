package com.moeiny.reza.deloittest.repository.database.dao

import androidx.room.*
import com.moeiny.reza.deloittest.repository.database.entitiy.PhotoEntity

@Dao
interface PhotoDao {

    @Query("SELECT * FROM Photo ")
    fun getAll(): List<PhotoEntity>

    @Query("SELECT * FROM Photo WHERE id = :id ")
    fun findByid(id: String): PhotoEntity

    @Query("DELETE FROM Photo")
    fun deleteAll()

    @Insert
    fun insert(photo: PhotoEntity)

    @Update
    fun update(photo: PhotoEntity)

    @Delete
    fun delete(photo: PhotoEntity)
}





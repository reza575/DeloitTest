package com.moeiny.reza.deloittest.repository.network

import com.moeiny.reza.deloittest.repository.model.PhotoPack
import io.reactivex.Flowable
import retrofit2.Retrofit
import retrofit2.http.*

interface PhotoApiService {

    @GET
    fun getPhotoPackInfo(@Url url: String): Flowable<PhotoPack>


    companion object Factory {
        fun create(retrofit: Retrofit): PhotoApiService {
            return retrofit.create(PhotoApiService::class.java)
        }
    }
}
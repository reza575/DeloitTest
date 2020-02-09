package com.moeiny.reza.deloittest.repository.network

import com.moeiny.reza.deloittest.repository.model.PhotoPack
import com.moeiny.reza.deloittest.utils.API
import io.reactivex.Flowable

class PhotoRepository(private val photoApiService: PhotoApiService) {

    fun getPhotoPackInfo(): Flowable<PhotoPack> {
        return photoApiService.getPhotoPackInfo(API.GET_PHOTO_URL.value)
    }

}
package com.moeiny.reza.deloittest.viewModel

import com.moeiny.reza.deloittest.repository.model.PhotoPack
import com.moeiny.reza.deloittest.utils.DeloitCallback


interface IPhotoService {

    fun getPhotoPackInfo(block: DeloitCallback<PhotoPack, Throwable>)

}
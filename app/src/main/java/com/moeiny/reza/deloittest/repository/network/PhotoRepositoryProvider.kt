package com.moeiny.reza.deloittest.repository.network

import retrofit2.Retrofit

object PhotoRepositoryProvider {

    fun providePhotoRepository(retrofit: Retrofit) : PhotoRepository {
        return PhotoRepository(
            PhotoApiService.create(
                retrofit
            )
        )
    }
}
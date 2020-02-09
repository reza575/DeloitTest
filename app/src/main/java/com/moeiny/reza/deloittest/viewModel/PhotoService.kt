package com.moeiny.reza.deloittest.viewModel

import com.moeiny.reza.deloittest.repository.model.PhotoPack
import com.moeiny.reza.deloittest.repository.network.PhotoRepositoryProvider
import com.moeiny.reza.deloittest.utils.DeloitCallback
import com.moeiny.reza.deloittest.utils.okHttpClientGETBuilder
import com.moeiny.reza.deloittest.utils.retrofit
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

open class PhotoService private constructor() {

    companion object {
        private var compositeDisposable: CompositeDisposable = CompositeDisposable()

        fun getPhotoPackInfo(block: DeloitCallback<PhotoPack, Throwable>) {
            val disposableService: Disposable = PhotoRepositoryProvider.providePhotoRepository(retrofit(okHttpClientGETBuilder()))
                .getPhotoPackInfo()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
//                .observeOn(Schedulers.computation())
                    .subscribe(
                            { result ->
                                block.onSuccess(result = result)
                            },
                            {error ->
                                block.onError(error)
                            },
                            {
                                block.onComplete()
                            }
                    )

            compositeDisposable.add(disposableService)

        }

    }

}
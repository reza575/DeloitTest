package com.moeiny.reza.deloittest

import com.moeiny.reza.deloittest.repository.model.PhotoPack
import com.moeiny.reza.deloittest.viewModel.PhotoService
import com.moeiny.reza.deloittest.utils.DeloitCallback
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.MockitoAnnotations
import java.util.concurrent.CountDownLatch

class TestGetPhotoPackInfo {
    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun testGetPhotoPackInfo() {

        val lock =  CountDownLatch(1)
        lateinit var photoPack: PhotoPack


        PhotoService.getPhotoPackInfo(object : DeloitCallback<PhotoPack, Throwable> {

            override fun onSuccess(result: PhotoPack) {
                Assert.assertNotNull(result)
                photoPack = result
                lock.countDown()
            }

            override fun onError(error: Throwable?) {
                Assert.assertNotNull(error)
                lock.countDown()
            }

            override fun onComplete() {
                print("complete")
                lock.countDown()
            }
        })

        //checking for the test Result
        photoPack.let {
            Assert.assertEquals(it.stat, "ok")
            Assert.assertEquals(it.photos.page, 1)
 //           Assert.assertEquals(it.photos.total, 179946)
        }
    }
}
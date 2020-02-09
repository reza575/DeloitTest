package com.moeiny.reza.deloittest

import com.moeiny.reza.deloittest.mock.FlickerAPISearchMock
import com.moeiny.reza.deloittest.repository.model.PhotoPack
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.MockitoAnnotations

class APIgetModelTest {
    lateinit var photoPackMock: PhotoPack

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        photoPackMock = FlickerAPISearchMock.photoPackMock
    }

    @Test
    fun testPhotosPackInfo() {
        
        Assert.assertEquals(photoPackMock.photos.page, 1)
        Assert.assertEquals(photoPackMock.photos.pages, 1795)
        Assert.assertEquals(photoPackMock.photos.perpage, 100)
        Assert.assertEquals(photoPackMock.photos.total, "179421")
    }

    @Test
    fun testFirstPhotoPackInfo() {

        Assert.assertEquals(photoPackMock.photos.photo.size, 100)
        Assert.assertEquals(photoPackMock.photos.photo.get(0).id, "49507801566")
        Assert.assertEquals(photoPackMock.photos.photo.get(0).owner, "185724874@N08")
        Assert.assertEquals(photoPackMock.photos.photo.get(0).secret, "1f3196ff57")
        Assert.assertEquals(photoPackMock.photos.photo.get(0).server, "65535")
        Assert.assertEquals(photoPackMock.photos.photo.get(0).farm, 66)
        Assert.assertEquals(photoPackMock.photos.photo.get(0).title, "Kitten")
        Assert.assertEquals(photoPackMock.photos.photo.get(0).ispublic, 1)
        Assert.assertEquals(photoPackMock.photos.photo.get(0).isfriend, 0)
        Assert.assertEquals(photoPackMock.photos.photo.get(0).isfamily, 0)

    }

    @Test
    fun testSecondPhotoPackWrongInfo() {

        Assert.assertNotEquals(photoPackMock.photos.photo.size, 50)
        Assert.assertNotEquals(photoPackMock.photos.photo.get(1).id, "49507573466")
        Assert.assertNotEquals(photoPackMock.photos.photo.get(1).owner, "88279978@N07")
        Assert.assertNotEquals(photoPackMock.photos.photo.get(1).secret, "25af46e4ae")
        Assert.assertNotEquals(photoPackMock.photos.photo.get(1).server, "65532")
        Assert.assertNotEquals(photoPackMock.photos.photo.get(1).farm, 68)
        Assert.assertNotEquals(photoPackMock.photos.photo.get(1).title, "Kitten")
        Assert.assertNotEquals(photoPackMock.photos.photo.get(1).ispublic, 0)
        Assert.assertNotEquals(photoPackMock.photos.photo.get(1).isfriend, 1)
        Assert.assertNotEquals(photoPackMock.photos.photo.get(1).isfamily, 1)
    }

    @Test
    fun testLastPhotoPackInfo() {

        Assert.assertEquals(photoPackMock.photos.photo.size, 100)
        Assert.assertEquals(photoPackMock.photos.photo.get(99).id, "49502964611")
        Assert.assertEquals(photoPackMock.photos.photo.get(99).owner, "60602272@N05")
        Assert.assertEquals(photoPackMock.photos.photo.get(99).secret, "29102e7fc9")
        Assert.assertEquals(photoPackMock.photos.photo.get(99).server, "65535")
        Assert.assertEquals(photoPackMock.photos.photo.get(99).farm, 66)
        Assert.assertEquals(photoPackMock.photos.photo.get(99).title, "Buddy (1)")
        Assert.assertEquals(photoPackMock.photos.photo.get(99).ispublic, 1)
        Assert.assertEquals(photoPackMock.photos.photo.get(99).isfriend, 0)
        Assert.assertEquals(photoPackMock.photos.photo.get(99).isfamily, 0)
    }
}
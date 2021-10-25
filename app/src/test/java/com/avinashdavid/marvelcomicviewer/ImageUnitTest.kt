package com.avinashdavid.marvelcomicviewer

import com.avinashdavid.marvelcomicviewer.api.models.Image
import org.junit.Assert
import org.junit.Test

class ImageUnitTest {
    @Test
    fun imageUrlTest() {
        val imagePath = "www.disney.com"
        val imageExtension = "jpg"
        val expectedImageUrl = "$imagePath/clean.$imageExtension"
        val image = Image(imagePath, imageExtension)
        Assert.assertEquals(image.imageUrl(), expectedImageUrl)
    }
}
package com.avinashdavid.marvelcomicviewer

import com.avinashdavid.marvelcomicviewer.api.models.Comic
import com.avinashdavid.marvelcomicviewer.api.models.Image
import org.junit.Assert
import org.junit.Test

class ComicUnitTest {
    @Test
    fun comicWithCoverImageTest() {
        val imagePath = "www.disney.com"
        val comicWithImage = Comic(1, 1, "Test comic", images = arrayOf(Image(imagePath, "jpg")))
        Assert.assertEquals(comicWithImage.coverImage(), "$imagePath/clean.jpg")
    }

    @Test
    fun comicWithNoCoverImageTest() {
        val imagePath = "www.disney.com"
        val comicWithImage = Comic(1, 1, "Test comic")
        Assert.assertNotEquals(comicWithImage.coverImage(), "$imagePath/clean.jpg")
    }
}
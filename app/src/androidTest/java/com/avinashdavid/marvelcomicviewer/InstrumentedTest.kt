package com.avinashdavid.marvelcomicviewer

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import com.avinashdavid.marvelcomicviewer.api.models.Comic
import com.avinashdavid.marvelcomicviewer.api.models.CreatorList
import com.avinashdavid.marvelcomicviewer.api.models.CreatorSummary
import com.avinashdavid.marvelcomicviewer.api.models.Image

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
@LargeTest
class InstrumentedTest {
    @Rule
    @JvmField
    val activityRule = ActivityTestRule(MainActivity::class.java, true, true)

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.avinashdavid.marvelcomicviewer", appContext.packageName)
    }

    @Test
    fun checkImageViewerLaunch() {
        delay(3)
        onView(withId(R.id.btViewFullComicCover)).perform(click())
        delay(1)
        onView(withId(R.id.ivFullScreenImage)).check(matches(isDisplayed()))
    }

    @Test
    fun checkCreatorRecyclerViewIsLoaded() {
        delay(3)
        onView(withId(R.id.rvComicCreators)).check(matches(hasMinimumChildCount(1)))
    }

    private fun delay(seconds: Long) {
        CountDownLatch(1).await(seconds, TimeUnit.SECONDS)
    }
}
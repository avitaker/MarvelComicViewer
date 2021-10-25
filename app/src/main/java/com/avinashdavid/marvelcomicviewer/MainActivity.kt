package com.avinashdavid.marvelcomicviewer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import java.lang.ref.WeakReference

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        instance = WeakReference(this)
        setContentView(R.layout.activity_main)
        findNavController(R.id.nav_host_fragment).addOnDestinationChangedListener { controller, destination, arguments ->
            when (destination.id) {
                R.id.comicInfoFragment -> {
                    title = getString(R.string.comic_info)
                }
            }
        }
    }

    companion object {
        lateinit var instance: WeakReference<MainActivity>
    }
}
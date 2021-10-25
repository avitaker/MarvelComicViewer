package com.avinashdavid.marvelcomicviewer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.avinashdavid.marvelcomicviewer.comicInfo.ComicInfoViewModel
import com.avinashdavid.marvelcomicviewer.comicList.ComicListViewModel
import java.lang.ref.WeakReference

class MainActivity : AppCompatActivity() {
    private val comicListViewModel: ComicListViewModel by viewModels()
    private val comicInfoViewModel: ComicInfoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        instance = WeakReference(this)
        setContentView(R.layout.activity_main)
        findNavController(R.id.nav_host_fragment).addOnDestinationChangedListener { controller, destination, arguments ->
            when (destination.id) {
                R.id.splashFragment -> {
                    title = ""
                }
                R.id.comicInfoFragment -> {
                    title = getString(R.string.comic_info)
                }
                R.id.fullScreenImageViewerFragment -> {
                    title = comicInfoViewModel.comic.value?.title
                }
            }
        }
        if (savedInstanceState == null) {
            comicListViewModel.apply {
                initiate()
                comics.observe(this@MainActivity) { comics ->
                    if (comics != null && comics.count() > 0) {
                        findNavController(R.id.nav_host_fragment).apply {
                            popBackStack()
                            navigate(R.id.comicInfoFragment)
                        }
                    }
                }
            }
        }
    }

    companion object {
        lateinit var instance: WeakReference<MainActivity>
    }
}
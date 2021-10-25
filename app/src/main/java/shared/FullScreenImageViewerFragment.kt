package shared

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.avinashdavid.marvelcomicviewer.R
import com.bumptech.glide.Glide
import com.google.android.material.transition.MaterialContainerTransform

class FullScreenImageViewerFragment : Fragment() {
    private var imageUrl: String? = null

    private lateinit var ivFullScreenImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition = MaterialContainerTransform()
        arguments?.getString(KEY_IMAGE_URL)?.let { url ->
            imageUrl = url
        } ?: run {
            savedInstanceState?.getString(KEY_IMAGE_URL)?.let { url ->
                imageUrl = url
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_imageviewer, container, false)

        ivFullScreenImage = view.findViewById(R.id.ivFullScreenImage)

        return view
    }

    override fun onStart() {
        super.onStart()
        imageUrl?.let {
            Glide.with(ivFullScreenImage).load(imageUrl).into(ivFullScreenImage)
        } ?: run {
            Toast.makeText(requireContext(), "", Toast.LENGTH_SHORT).show()
            findNavController().popBackStack()
        }
    }

    companion object {
        const val KEY_IMAGE_URL = "KEY_IMAGE_URL"

        fun getArgumentsFor(imageUrl: String) = Bundle().apply {
            putString(KEY_IMAGE_URL, imageUrl)
        }
    }
}
package com.avinashdavid.marvelcomicviewer

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.content.DialogInterface.OnShowListener
import android.content.res.Resources
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.bottomsheet.BottomSheetBehavior
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.fragment.app.FragmentActivity
import com.bumptech.glide.Glide
import com.google.android.material.bottomsheet.BottomSheetDialog

class FullScreenImageViewerFragment : BottomSheetDialogFragment() {
    private var imageUrl: String? = null

    private lateinit var ivFullScreenImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.getString(KEY_IMAGE_URL)?.let { url ->
            imageUrl = url
        } ?: run {
            savedInstanceState?.getString(KEY_IMAGE_URL)?.let { url ->
                imageUrl = url
            }
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val bottomSheetDialog = super.onCreateDialog(savedInstanceState) as BottomSheetDialog
        bottomSheetDialog.setOnShowListener { dialog: DialogInterface ->
            val dialogc = dialog as BottomSheetDialog
            // When using AndroidX the resource can be found at com.google.android.material.R.id.design_bottom_sheet
            val bottomSheet =
                dialogc.findViewById<FrameLayout>(com.google.android.material.R.id.design_bottom_sheet)!!
            val bottomSheetBehavior =
                BottomSheetBehavior.from(bottomSheet)
            bottomSheetBehavior.apply {
                peekHeight = Resources.getSystem().displayMetrics.heightPixels
                skipCollapsed = true
                state = BottomSheetBehavior.STATE_EXPANDED
            }
        }
        return bottomSheetDialog
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
            dismiss()
        }
    }

    companion object {
        const val KEY_IMAGE_URL = "KEY_IMAGE_URL"

        fun displayImage(activity: FragmentActivity, imageUrl: String) {
            val fragment = FullScreenImageViewerFragment()
            fragment.arguments = Bundle().apply {
                putString(KEY_IMAGE_URL, imageUrl)
            }
            fragment.show(activity.supportFragmentManager, "FullScreenImageViewerFragment$imageUrl")
        }
    }
}
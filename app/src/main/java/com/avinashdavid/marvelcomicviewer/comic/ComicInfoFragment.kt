package com.avinashdavid.marvelcomicviewer.comic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.avinashdavid.marvelcomicviewer.FullScreenImageViewerFragment
import com.avinashdavid.marvelcomicviewer.R
import com.avinashdavid.marvelcomicviewer.databinding.FragmentComicInfoBinding
import com.bumptech.glide.Glide

class ComicInfoFragment : Fragment() {
    private var _binding: FragmentComicInfoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentComicInfoBinding.inflate(inflater, container, false)
        val view = binding.root

        Glide.with(binding.ivComicCover).load("https://www.comicbookdaily.com/wp-content/uploads/2020/10/t-dd-53.jpg").into(binding.ivComicCover)
        binding.tvComicTitle.text = "Captain America Lives Again"
        binding.tvComicDescription.text = "Paragraphs are the building blocks of papers. Many students define paragraphs in terms of length: a paragraph is a group of at least five sentences, a paragraph is half a page long, etc. In reality, though, the unity and coherence of ideas among sentences is what constitutes a paragraph. A paragraph is defined as “a group of sentences or a single sentence that forms a unit” (Lunsford and Connors 116). Length and appearance do not determine whether a section in a paper is a paragraph. For instance, in some styles of writing, particularly journalistic styles, a paragraph can be just one sentence long. Ultimately, a paragraph is a sentence or group of sentences that support one main idea. In this handout, we will refer to this as the “controlling idea,” because it controls what happens in the rest of the paragraph.\n" +
                "\n"

        binding.btViewFullComicCover.setOnClickListener {
            FullScreenImageViewerFragment.displayImage(requireActivity(), "https://www.comicbookdaily.com/wp-content/uploads/2020/10/t-dd-53.jpg")
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
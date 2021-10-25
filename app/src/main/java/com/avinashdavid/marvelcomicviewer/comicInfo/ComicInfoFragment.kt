package com.avinashdavid.marvelcomicviewer.comicInfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.avinashdavid.marvelcomicviewer.FullScreenImageViewerFragment
import com.avinashdavid.marvelcomicviewer.R
import com.avinashdavid.marvelcomicviewer.comicList.ComicListViewModel
import com.avinashdavid.marvelcomicviewer.databinding.FragmentComicInfoBinding
import com.bumptech.glide.Glide

class ComicInfoFragment : Fragment() {
    private val comicListViewModel: ComicListViewModel by activityViewModels()
    private val comicInfoViewModel: ComicInfoViewModel by activityViewModels()

    private var _binding: FragmentComicInfoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentComicInfoBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.btViewFullComicCover.setOnClickListener {
            FullScreenImageViewerFragment.displayImage(requireActivity(), "https://www.comicbookdaily.com/wp-content/uploads/2020/10/t-dd-53.jpg")
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        comicListViewModel.apply {
            comics.observe(viewLifecycleOwner) { comics ->
                comics?.getOrNull(currentComicIndex)?.id?.let { comicId ->
                    comicInfoViewModel.initiate(comicId)
                }
                binding.btPrevious.apply {
                    isEnabled = currentComicIndex > 0
                    setOnClickListener { currentComicIndex-- }
                }
                binding.btNext.apply {
                    isEnabled = currentComicIndex < maxComics - 1
                    setOnClickListener { currentComicIndex++ }
                }
            }
        }
        comicInfoViewModel.comics.observe(viewLifecycleOwner) { comic ->
            comic?.let {
                Glide.with(binding.ivComicCover).load(comic.coverImage()).into(binding.ivComicCover)
                binding.tvComicTitle.text = comic.title
                binding.tvComicDescription.text = comic.description
                binding.btViewFullComicCover.setOnClickListener {
                    comic.coverImage()?.let {
                        FullScreenImageViewerFragment.displayImage(requireActivity(), it)
                    } ?: run {
                        Toast.makeText(requireContext(), getString(R.string.message_cover_image_not_available), Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
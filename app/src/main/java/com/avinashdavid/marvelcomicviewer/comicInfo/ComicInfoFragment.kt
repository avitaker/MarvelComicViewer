package com.avinashdavid.marvelcomicviewer.comicInfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import shared.FullScreenImageViewerFragment
import com.avinashdavid.marvelcomicviewer.R
import com.avinashdavid.marvelcomicviewer.comicList.ComicListViewModel
import com.avinashdavid.marvelcomicviewer.databinding.FragmentComicInfoBinding
import com.bumptech.glide.Glide
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.transition.MaterialElevationScale
import android.content.Intent
import android.net.Uri


class ComicInfoFragment : Fragment() {
    private val comicListViewModel: ComicListViewModel by activityViewModels()
    private val comicInfoViewModel: ComicInfoViewModel by activityViewModels()

    private var _binding: FragmentComicInfoBinding? = null
    private val binding get() = _binding!!

    private lateinit var creatorAdapter: CreatorAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        exitTransition = MaterialElevationScale(/* growing= */ false)
        reenterTransition = MaterialElevationScale(/* growing= */ true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentComicInfoBinding.inflate(inflater, container, false)
        creatorAdapter = CreatorAdapter(requireActivity())
        binding.rvComicCreators.adapter = creatorAdapter
        binding.appbarLayout.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
            if (Math.abs(verticalOffset)- (appBarLayout?.totalScrollRange ?: 0) == 0) {
                binding.tvAttribution.visibility = View.VISIBLE
            } else {
                binding.tvAttribution.visibility = View.GONE
            }
        })
        return binding.root
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
        comicInfoViewModel.comic.observe(viewLifecycleOwner) { comic ->
            comic?.let {
                Glide.with(binding.ivComicCover).load(comic.coverImage()).into(binding.ivComicCover)
                binding.tvComicTitle.text = comic.title
                binding.tvComicDescription.text = comic.fullDescriptionString(requireContext())
                binding.btViewFullComicCover.setOnClickListener {
                    comic.coverImage()?.let {
                        binding.btViewFullComicCover.apply {
                            setTextColor(ResourcesCompat.getColor(resources, R.color.black, null))
                            setIconTintResource(R.color.black)
                        }
                        val extras = FragmentNavigatorExtras(binding.btViewFullComicCover to getString(R.string.transition_name_full_screen_image))
                        val args = FullScreenImageViewerFragment.getArgumentsFor(it)
                        findNavController().navigate(R.id.action_comicInfoFragment_to_fullScreenImageViewerFragment, args, null, extras)
                    } ?: run {
                        Toast.makeText(requireContext(), getString(R.string.message_image_not_viewable), Toast.LENGTH_LONG).show()
                    }
                }
                comic.creators?.items?.let { creators ->
                    creatorAdapter.setItems(creators.toList())
                }
                comic.urls?.firstOrNull()?.url?.let { url ->
                    binding.tvAttribution.setOnClickListener {
                        val i = Intent(Intent.ACTION_VIEW)
                        i.data = Uri.parse(url)
                        startActivity(i)
                    }
                }
                binding.tvComicIndex.text = getString(R.string.format_comic_index, comicListViewModel.currentComicIndex + 1, comicListViewModel.maxComics)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
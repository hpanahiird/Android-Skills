package ir.hpanahi.androidskills.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import ir.hpanahi.androidskills.databinding.FragmentMediaBinding
import ir.hpanahi.androidskills.viewmodels.PhotosViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


@AndroidEntryPoint
class MediaFragment : Fragment() {

    private val adapter = PexelsPhotoAdapter()
    private val viewModel: PhotosViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val binding = FragmentMediaBinding.inflate(inflater, container, false)
        context ?: return binding.root

        binding.photoList.adapter = adapter
        lifecycleScope.launch {
            viewModel.searchPhotos("all").collectLatest {
                adapter.submitData(it)
            }
        }
        return binding.root
    }
}
package com.alekseykostyunin.hw18_attractions.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.alekseykostyunin.hw18_attractions.R
import com.alekseykostyunin.hw18_attractions.databinding.FragmentListPhotoBinding
import com.alekseykostyunin.hw18_attractions.domain.ListPhotoViewModel
import com.alekseykostyunin.hw18_attractions.domain.PhotoAdapter
import kotlinx.coroutines.launch

class ListPhotoFragment : Fragment() {

    private var _binding: FragmentListPhotoBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ListPhotoViewModel by viewModels()
    private val adapter = PhotoAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListPhotoBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.actionCreatePhoto.setOnClickListener {
            findNavController().navigate(R.id.action_list_photo_to_create_photo)
        }
        lifecycleScope.launch {
            viewModel.allPhotos.collect {
                adapter.setData(it)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
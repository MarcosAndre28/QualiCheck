package com.example.qualicheck.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.qualicheck.R
import com.example.qualicheck.databinding.FragmentQualityBinding
import com.example.qualicheck.databinding.FragmentSplashBinding

class QualityFragment : Fragment() {

    private var _binding : FragmentQualityBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentQualityBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
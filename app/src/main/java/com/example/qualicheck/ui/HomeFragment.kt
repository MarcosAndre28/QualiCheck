package com.example.qualicheck.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.qualicheck.R
import com.example.qualicheck.adapter.ViewPagerAdapter
import com.example.qualicheck.databinding.FragmentHomeBinding
import com.example.qualicheck.databinding.FragmentTheftBinding
import com.google.android.material.tabs.TabLayoutMediator

class HomeFragment : Fragment() {

    private var _binding : FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initTabs()
    }

    private fun initTabs(){
        val pageAdapter = ViewPagerAdapter(requireActivity())
        binding.viewPage.adapter = pageAdapter

        pageAdapter.addFragment(ConsumptionFragment(),R.string.status_consumption)
        pageAdapter.addFragment(QualityFragment(),R.string.status_quality)
        pageAdapter.addFragment(MaturityFragment(),R.string.status_maturity)
        pageAdapter.addFragment(TheftFragment(),R.string.status_theft)

        binding.viewPage.offscreenPageLimit = pageAdapter.itemCount

        TabLayoutMediator(binding.tabs, binding.viewPage){tab, position ->
            tab.text = getString(pageAdapter.getTitle(position))

        }.attach()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
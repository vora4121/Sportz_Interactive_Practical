package com.android.sportz.interactive.practical.ui.allteams

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.sportz.interactive.practical.R
import com.android.sportz.interactive.practical.databinding.FragmentAllTeamsBinding
import com.android.sportz.interactive.practical.utils.AppConstant

class AllTeamsFragment : Fragment() {
    val binding: FragmentAllTeamsBinding by lazy { FragmentAllTeamsBinding.inflate(layoutInflater) }
    lateinit var allTeamsAdapter: AllTeamsAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupList()
        binding.btnStartIpl.setOnClickListener {
            findNavController().navigate(
                R.id.action_allTeamsFragment_to_simulateTeamsFragment
            )
        }
    }

    private fun setupList() {
        binding.rvTeamsList.layoutManager = LinearLayoutManager(requireContext())
        allTeamsAdapter = AllTeamsAdapter()
        binding.rvTeamsList.adapter = allTeamsAdapter
        allTeamsAdapter.setItem(AppConstant.teams)
    }

}
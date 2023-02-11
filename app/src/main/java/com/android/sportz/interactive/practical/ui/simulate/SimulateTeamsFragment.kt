package com.android.sportz.interactive.practical.ui.simulate

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.sportz.interactive.practical.R
import com.android.sportz.interactive.practical.databinding.FragmentSimulateTeamsBinding
import com.android.sportz.interactive.practical.ui.allteams.AllTeamsAdapter
import com.android.sportz.interactive.practical.utils.AppConstant
import kotlin.collections.ArrayList

class SimulateTeamsFragment : Fragment() {

    val binding: FragmentSimulateTeamsBinding by lazy {
        FragmentSimulateTeamsBinding.inflate(
            layoutInflater
        )
    }

    var arrPairedTeam = ArrayList<String>()

    lateinit var allTeamsAdapter: AllTeamsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupList(AppConstant.teams)

        binding.btnSimulate.setOnClickListener {
            if (arrPairedTeam.size > 1){
                setupList(AppConstant.simulatePairedTeams(arrPairedTeam))
            }else{

                val bundle = Bundle()
                bundle.putString("final_teams", (arrPairedTeam)[0])

                findNavController().navigate(
                    R.id.action_simulateTeamsFragment_to_winnerTeamFragment,
                    bundle

                )
            }
        }

    }

    private fun setupList(teams: ArrayList<String>) {
        arrPairedTeam.clear()
        binding.rvTeamsList.layoutManager = LinearLayoutManager(requireContext())
        allTeamsAdapter = AllTeamsAdapter()
        binding.rvTeamsList.adapter = allTeamsAdapter
        arrPairedTeam = AppConstant.simulateTeams(teams)
        allTeamsAdapter.setItem(arrPairedTeam)
    }
}
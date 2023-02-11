package com.android.sportz.interactive.practical.ui.winnerteam

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.android.sportz.interactive.practical.R
import com.android.sportz.interactive.practical.databinding.FragmentWinnerTeamBinding
import com.android.sportz.interactive.practical.utils.AppConstant

class WinnerTeamFragment : Fragment() {

    val binding: FragmentWinnerTeamBinding by lazy {
        FragmentWinnerTeamBinding.inflate(
            layoutInflater
        )
    }

    val staticTeams = arrayListOf(
        "Mumbai Indians", "Sunrisers Hyderabad",
        "Royal Challengers Bangalore", "Rajasthan Royals",
        "Chennai Super Kings", "Kolkata Knight Riders",
        "Delhi Capitals", "Kings XI Punjab"
    )


    var finalTeams = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        finalTeams = requireArguments().getString("final_teams", "")

        val position = AppConstant.generateRendomeNumber()

        val findTwoTeams = finalTeams.split("Vs") as ArrayList<String>
        findTwoTeams.shuffle()

        binding.tv1stTeamName.text = "Winner goes to${findTwoTeams[position].replace("\n", "")}"
        findTwoTeams.removeAt(position)
        binding.tv2ndTeamName.text  = "Runner up${findTwoTeams[0].replace("\n", "")}"

        binding.btnResult.setOnClickListener {
            AppConstant.teams.clear()
            AppConstant.teams.addAll(staticTeams)
            findNavController().navigate(
                R.id.action_winnerTeamFragment_to_teamSelectionFragment
            )
        }

    }
}
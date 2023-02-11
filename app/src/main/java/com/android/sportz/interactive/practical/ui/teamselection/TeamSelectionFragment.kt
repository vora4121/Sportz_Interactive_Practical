package com.android.sportz.interactive.practical.ui.teamselection

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.sportz.interactive.practical.R
import com.android.sportz.interactive.practical.databinding.FragmentTeamSelectionBinding
import com.android.sportz.interactive.practical.utils.Alert
import com.android.sportz.interactive.practical.utils.AppConstant

class TeamSelectionFragment : Fragment(), View.OnClickListener {

    val binding: FragmentTeamSelectionBinding by lazy {
        FragmentTeamSelectionBinding.inflate(
            layoutInflater
        )
    }

    lateinit var teamEnteredAdapter: TeamEnteredAdapter
    var arrTeams = ArrayList<String>()
    var isValidTeamSize = false
    var teamSize = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
    }

    private fun setupView() {

        with(binding) {

            rvTeams.layoutManager = LinearLayoutManager(requireContext())
            teamEnteredAdapter = TeamEnteredAdapter()
            rvTeams.adapter = teamEnteredAdapter

            btnContinueWithDynamicTeam.setOnClickListener(this@TeamSelectionFragment)
            btnContinueWithStaticTeam.setOnClickListener(this@TeamSelectionFragment)
            btnSubmit.setOnClickListener(this@TeamSelectionFragment)
            btnVerifyTeam.setOnClickListener(this@TeamSelectionFragment)
            ivAddTeam.setOnClickListener(this@TeamSelectionFragment)
        }
    }

    override fun onClick(view: View?) {

        when (view?.id) {

            R.id.btn_submit -> {
                if(arrTeams.size == teamSize){
                    AppConstant.teams.clear()
                    AppConstant.teams.addAll(arrTeams)
                    findNavController().navigate(
                        R.id.action_teamSelectionFragment_to_simulateTeamsFragment
                    )
                }else{
                    Alert("Team name and team size mis match, Please enter team name")
                }
            }

            R.id.iv_add_team -> {
                if (TextUtils.isEmpty(binding.edtTeamSize.text.toString())){
                    Alert("Please enter Team Size")
                }else if (!isValidTeamSize){
                    Alert("Please validate Team size")
                }else if (TextUtils.isEmpty(binding.edtTeamName.text.toString())){
                    Alert("Please enter Team name")
                }else if (arrTeams.size == teamSize){
                    Alert("You are not able to add more Teams")
                }else{
                    if (arrTeams.contains(binding.edtTeamName.text.toString())){
                        Alert("Team name already exists")
                    }else{
                        arrTeams.add(binding.edtTeamName.text.toString())
                        teamEnteredAdapter.setItem(binding.edtTeamName.text.toString())
                        binding.edtTeamName.setText("")
                    }
                }
            }

            R.id.btn_continue_with_dynamic_team -> {
                binding.clTeamsType.visibility = View.GONE
            }

            R.id.btn_continue_with_static_team -> {
                binding.clTeamsType.visibility = View.GONE
                findNavController().navigate(
                    R.id.action_teamSelectionFragment_to_allTeamsFragment
                )
            }

            R.id.btn_verify_team -> {
                if (TextUtils.isEmpty(binding.edtTeamSize.text.toString())) {
                    Alert("Please enter Team size")
                    return
                } else if (AppConstant.validateTeamSize(binding.edtTeamSize.text.toString().toInt())) {
                    Alert("Team size verified")
                    teamSize = binding.edtTeamSize.text.toString().toInt()
                    binding.edtTeamName.visibility = View.VISIBLE
                    binding.ivAddTeam.visibility = View.VISIBLE
                    isValidTeamSize = true
                } else {
                    Alert("Please enter valid Team Size, With this team size we are not able to identify winner team")
                }
            }
        }
    }


}
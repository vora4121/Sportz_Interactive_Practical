package com.android.sportz.interactive.practical.ui.teamselection

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.sportz.interactive.practical.databinding.ItemEnteredTeamBinding

class TeamEnteredAdapter : RecyclerView.Adapter<TeamEnteredAdapter.ViewHolder >() {
    val arrTeams= ArrayList<String>()

    fun setItem(team: String){
        arrTeams.add(team)
        notifyItemInserted(arrTeams.size - 1)
    }

    class ViewHolder(private val itemBinding: ItemEnteredTeamBinding) : RecyclerView.ViewHolder(itemBinding.root){
        fun bind(teamName: String, position: Int){
            itemBinding.tvTeamName.text = teamName
            itemBinding.tvTeamNumber.text = "${position+1}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemEnteredTeamBinding = ItemEnteredTeamBinding.inflate( LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int  = arrTeams.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(arrTeams[position], position)
    }

}
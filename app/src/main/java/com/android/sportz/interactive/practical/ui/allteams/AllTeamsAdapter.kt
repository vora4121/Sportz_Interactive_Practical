package com.android.sportz.interactive.practical.ui.allteams

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.sportz.interactive.practical.databinding.ItemTeamBinding

class AllTeamsAdapter : RecyclerView.Adapter<AllTeamsAdapter.ViewHolder>() {

    private val arrTeam = ArrayList<String>()

    fun setItem(items: ArrayList<String>) {
        arrTeam.clear()
        arrTeam.addAll(items)
        notifyDataSetChanged()
    }


    class ViewHolder(val itemBinding: ItemTeamBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(teamName: String) {
            itemBinding.tvTeamName.text = teamName
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemTeamBinding =
            ItemTeamBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(arrTeam[position])
    }

    override fun getItemCount(): Int = arrTeam.size

}
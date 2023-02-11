package com.android.sportz.interactive.practical.utils

import java.util.*
import kotlin.collections.ArrayList

object AppConstant {

    val teams = arrayListOf(
        "Mumbai Indians", "Sunrisers Hyderabad",
        "Royal Challengers Bangalore", "Rajasthan Royals",
        "Chennai Super Kings", "Kolkata Knight Riders",
        "Delhi Capitals", "Kings XI Punjab"
    )

    fun simulateTeams(team: ArrayList<String>): ArrayList<String> {
        val arrTeam = ArrayList<String>()
        team.shuffle()
        for (i in 0 until team.size / 2) {
            val firstTeam = team[i]
            val secondTeam = team[team.size - i - 1]
            arrTeam.add("$firstTeam \nVs\n $secondTeam")
        }
        return arrTeam
    }

    fun simulatePairedTeams(arrPairedTeam: ArrayList<String>): ArrayList<String> {
        var arrSimuLatedTeams = ArrayList<String>()
        arrPairedTeam.forEach {
            arrSimuLatedTeams.add(it.split("Vs")[generateRendomeNumber()].replace("\n", ""))
        }
        return arrSimuLatedTeams
    }

    fun generateRendomeNumber(): Int{
        return Random().nextInt(1 - 0 + 1) + 0
    }

    fun validateTeamSize(teamSize: Int): Boolean {
        var teamNumber = teamSize
        if (teamNumber % 2 == 0 && teamNumber > 0) {
            while (teamNumber != 2) {
                teamNumber /= 2
                if (teamNumber % 2 != 0) {
                    return false
                }
            }
            return true
        } else {
            return false
        }
    }

}
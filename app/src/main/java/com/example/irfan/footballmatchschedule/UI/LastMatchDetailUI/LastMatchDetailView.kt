package com.example.irfan.footballmatchschedule.UI.LastMatchDetailUI

import com.example.irfan.footballmatchschedule.Model.MatchDetail
import com.example.irfan.footballmatchschedule.Model.TeamItems

interface LastMatchDetailView{

    fun showLoading()
    fun hideLoading()
    fun showTeamDetails(dataHomeTeam: List<TeamItems>, dataAwayTeam: List<TeamItems>)
    fun showMatchDetails(dataDetailMatch: List<MatchDetail>)
}
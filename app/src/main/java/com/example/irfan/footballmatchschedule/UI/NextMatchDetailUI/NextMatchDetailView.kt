package com.example.irfan.footballmatchschedule.UI.NextMatchDetailUI

import com.example.irfan.footballmatchschedule.Model.MatchDetail
import com.example.irfan.footballmatchschedule.Model.TeamItems

interface NextMatchDetailView{

    fun showLoading()
    fun hideLoading()
    fun showTeamDetails(dataHomeTeam: List<TeamItems>, dataAwayTeam: List<TeamItems>)
    fun showMatchDetails(dataDetailMatch: List<MatchDetail>)
}
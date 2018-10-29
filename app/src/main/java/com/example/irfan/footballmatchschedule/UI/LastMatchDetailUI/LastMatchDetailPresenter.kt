package com.example.irfan.footballmatchschedule.UI.LastMatchDetailUI

import com.example.irfan.footballmatchschedule.API.ApiRepository
import com.example.irfan.footballmatchschedule.API.TheSportDBApi
import com.example.irfan.footballmatchschedule.Model.ResponseMatchDetail
import com.example.irfan.footballmatchschedule.Model.ResponseTeamItems
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class LastMatchDetailPresenter(private val view: LastMatchDetailView,
                               private val apiRepository: ApiRepository,
                               private val gson: Gson){

    fun getTeamDetail(idHomeTeam: String?, idAwayTeam: String?){
        doAsync {
            val dataHomeTeam = gson.fromJson(
                apiRepository.doRequest(TheSportDBApi.getTeamsDetail(idHomeTeam.toString())),
                ResponseTeamItems::class.java)

            val dataAwayTeam = gson.fromJson(
                apiRepository.doRequest(TheSportDBApi.getTeamsDetail(idAwayTeam.toString())),
                ResponseTeamItems::class.java)

            uiThread {
                view.hideLoading()
                view.showTeamDetails(dataHomeTeam.teams!!, dataAwayTeam.teams!!)
            }
        }
    }

    fun getMatchDetail(idEvent: String?){
        doAsync {
            val dataDetailMatch = gson.fromJson(
                apiRepository.doRequest(TheSportDBApi.getMatchDetail(idEvent.toString())),
                ResponseMatchDetail::class.java
            )

            uiThread {
                view.hideLoading()
                view.showMatchDetails(dataDetailMatch.events!!)
            }
        }
    }
}
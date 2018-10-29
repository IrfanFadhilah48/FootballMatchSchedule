package com.example.irfan.footballmatchschedule.UI.LastMatchUI

import com.example.irfan.footballmatchschedule.API.ApiRepository
import com.example.irfan.footballmatchschedule.API.TheSportDBApi
import com.example.irfan.footballmatchschedule.Model.EventResponseLast
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class LastMatchPresenter(private val view: LastMatchView, private val apiRepository: ApiRepository, private val gson: Gson){

    fun getEventsLast(){
        view.showLoading()

        doAsync {
            val data = gson.fromJson(apiRepository
                .doRequest(TheSportDBApi.getPrevLeagueTeams()),
                EventResponseLast::class.java
            )

            uiThread {
                view.hideLoading()
                view.showEventList(data.events!!)
            }
        }
    }
}
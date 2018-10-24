package com.example.irfan.footballmatchschedule.API

import com.example.irfan.footballmatchschedule.BuildConfig

object TheSportDBApi{
    fun getTeams(league : String): String{
        return BuildConfig.BASE_URL + "api/v1/json/${BuildConfig.TSDB_API_KEY}" + "/search_all_teams.php?l=" + league
    }
}
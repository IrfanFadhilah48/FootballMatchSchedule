package com.example.irfan.footballmatchschedule.API

import com.example.irfan.footballmatchschedule.BuildConfig

object TheSportDBApi{

    fun getAllTeams(league : String): String{
        return BuildConfig.BASE_URL + "api/v1/json/${BuildConfig.TSDB_API_KEY}" + "/search_all_teams.php?l=" + league
    }

    fun getPrevLeagueTeams(): String{
        return BuildConfig.BASE_URL + "api/v1/json/${BuildConfig.TSDB_API_KEY}" + "/eventspastleague.php?id=4328"
    }

    fun getNextLeagueTeams(): String{
        return BuildConfig.BASE_URL + "api/v1/json/${BuildConfig.TSDB_API_KEY}" + "/eventsnextleague.php?id=4328"
    }

    fun getMatchDetail(id: String): String{
        return BuildConfig.BASE_URL + "api/v1/json/${BuildConfig.TSDB_API_KEY}" + "/lookupevent.php?id=${id}"

    }

    fun getTeamsDetail(id: String): String{
        return BuildConfig.BASE_URL + "api/v1/json/${BuildConfig.TSDB_API_KEY}" + "/lookupteam.php?id=${id}"
    }
}
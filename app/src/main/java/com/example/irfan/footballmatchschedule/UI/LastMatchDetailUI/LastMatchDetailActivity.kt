package com.example.irfan.footballmatchschedule.UI.LastMatchDetailUI

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.ProgressBar
import com.example.irfan.footballmatchschedule.API.ApiRepository
import com.example.irfan.footballmatchschedule.Model.EventsLastLeague
import com.example.irfan.footballmatchschedule.Model.MatchDetail
import com.example.irfan.footballmatchschedule.Model.TeamItems
import com.example.irfan.footballmatchschedule.R
import com.example.irfan.footballmatchschedule.Utils.DateTimeConverter
import com.example.irfan.footballmatchschedule.Utils.invisible
import com.example.irfan.footballmatchschedule.Utils.visible
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_last_match_detail.*
import org.jetbrains.anko.find

class LastMatchDetailActivity: AppCompatActivity(), LastMatchDetailView {

    private lateinit var presenter: LastMatchDetailPresenter
    private lateinit var progressBar: ProgressBar
    private lateinit var data: EventsLastLeague
    private var matches: MutableList<MatchDetail> = mutableListOf()

    companion object {
        const val INTENT = "INTENT_DATA"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_last_match_detail)

        data = intent.getParcelableExtra(INTENT)
        progressBar = find(R.id.progressBarDetail)

        presenter = LastMatchDetailPresenter(this, ApiRepository(), Gson())
        presenter.getMatchDetail(data.idEvent.toString())
        Log.d("DATAArray", data.toString())
        presenter.getTeamDetail(data.idHomeTeam, data.idAwayTeam)
    }

    override fun showLoading() {
        progressBar.visible()
    }

    override fun hideLoading() {
        progressBar.invisible()
    }

    override fun showTeamDetails(dataHomeTeam: List<TeamItems>, dataAwayTeam: List<TeamItems>) {
        Picasso.get().load(dataHomeTeam[0].strTeamBadge).into(imageHomeTeamDetail)
        Picasso.get().load(dataAwayTeam[0].strTeamBadge).into(imageAwayTeamDetail)
    }

    override fun showMatchDetails(dataDetailMatch: List<MatchDetail>) {
        supportActionBar?.title = dataDetailMatch[0].strEvent
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        presenter.getTeamDetail(dataDetailMatch[0].idHomeTeam, dataDetailMatch[0].idAwayTeam)
        matches.clear()
        matches.addAll(dataDetailMatch)

        textViewLeague.text = dataDetailMatch[0].strLeague
        textViewDateMatchDetail.text = DateTimeConverter.longDate(dataDetailMatch[0].dateEvent!!)

        textViewHomeTeamDetail.text = dataDetailMatch[0].strHomeTeam
        textViewAwayTeamDetail.text = dataDetailMatch[0].strAwayTeam

        textViewGoalHomeTeamDetail.text = dataDetailMatch[0].strHomeGoalDetails
        textViewGoalAwayTeamDetail.text = dataDetailMatch[0].strAwayGoalDetails

        if (dataDetailMatch[0].intHomeShots == null || dataDetailMatch[0].intAwayShots == null){
            textViewShotsHomeTeamDetail.text = "-"
            textViewShotsAwayTeamDetail.text = "-"
        }else{
            textViewShotsHomeTeamDetail.text = dataDetailMatch[0].intHomeShots
            textViewShotsAwayTeamDetail.text = dataDetailMatch[0].intAwayShots
        }

        textViewHomeScore.text = dataDetailMatch[0].intHomeScore
        textViewAwayScore.text = dataDetailMatch[0].intAwayScore

        textViewGKHomeTeam.text = dataDetailMatch[0].strHomeLineupGoalkeeper
        textViewGKAwayTeam.text = dataDetailMatch[0].strAwayLineupGoalkeeper

        textViewDefendersHomeTeam.text = dataDetailMatch[0].strHomeLineupDefense
        textViewDefendersAwayTeam.text = dataDetailMatch[0].strAwayLineupDefense

        textViewMidefieldsHomeTeam.text = dataDetailMatch[0].strHomeLineupMidfield
        textViewMidefieldsAwayTeam.text = dataDetailMatch[0].strAwayLineupMidfield

        textViewForwardsHomeTeam.text = dataDetailMatch[0].strHomeLineupForward
        textViewForwardsAwayTeam.text = dataDetailMatch[0].strAwayLineupForward

        textViewSubtitutionsHomeTeam.text = dataDetailMatch[0].strHomeLineupSubstitutes
        textViewSubtitutionsAwayTeam.text = dataDetailMatch[0].strAwayLineupSubstitutes

        textViewYellowCardHomeTeam.text = dataDetailMatch[0].strHomeYellowCards
        textViewYellowCardAwayTeam.text = dataDetailMatch[0].strAwayYellowCards

        if (dataDetailMatch[0].strHomeRedCards.isNullOrEmpty() ||  dataDetailMatch[0].strAwayRedCards.isNullOrEmpty()){
            textViewRedCardsHomeTeam.text = "-"
            textViewRedCardsAwayTeam.text = "-"
        }else{
            textViewRedCardsHomeTeam.text = dataDetailMatch[0].strHomeRedCards
            textViewRedCardsAwayTeam.text = dataDetailMatch[0].strAwayRedCards
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}
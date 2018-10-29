package com.example.irfan.footballmatchschedule.UI.NextMatchDetailUI

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ProgressBar
import com.example.irfan.footballmatchschedule.API.ApiRepository
import com.example.irfan.footballmatchschedule.Model.EventsNextLeague
import com.example.irfan.footballmatchschedule.Model.MatchDetail
import com.example.irfan.footballmatchschedule.Model.TeamItems
import com.example.irfan.footballmatchschedule.R
import com.example.irfan.footballmatchschedule.Utils.DateTimeConverter
import com.example.irfan.footballmatchschedule.Utils.invisible
import com.example.irfan.footballmatchschedule.Utils.visible
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_next_match_detail.*
import org.jetbrains.anko.find

class NextMatchDetailActivity: AppCompatActivity(), NextMatchDetailView{

    private lateinit var presenter: NextMatchDetailPresenter
    private lateinit var progressBar: ProgressBar
    private lateinit var data: EventsNextLeague
    private var matches: MutableList<MatchDetail> = mutableListOf()

    companion object {
        const val INTENT_NEXT = "INTENT_NEXT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next_match_detail)

        data = intent.getParcelableExtra<EventsNextLeague>(INTENT_NEXT)
        progressBar = find(R.id.progressBarDetailNext)

        presenter = NextMatchDetailPresenter(this, ApiRepository(), Gson())
        presenter.getMatchDetail(data.idEvent)
        presenter.getTeamDetail(data.idHomeTeam, data.idAwayTeam)

    }
    override fun showLoading() {
        progressBar.visible()
    }

    override fun hideLoading() {
        progressBar.invisible()
    }

    override fun showTeamDetails(dataHomeTeam: List<TeamItems>, dataAwayTeam: List<TeamItems>) {
        Picasso.get().load(dataHomeTeam[0].strTeamBadge).into(imageHomeTeamDetailNext)
        Picasso.get().load(dataAwayTeam[0].strTeamBadge).into(imageAwayTeamDetailNext)
    }

    override fun showMatchDetails(dataDetailMatch: List<MatchDetail>) {
        supportActionBar?.title = dataDetailMatch[0].strEvent
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        presenter.getTeamDetail(dataDetailMatch[0].idHomeTeam, dataDetailMatch[0].idAwayTeam)
        matches.clear()
        matches.addAll(dataDetailMatch)

        textViewLeagueNext.text = dataDetailMatch[0].strLeague
        textViewDateMatchDetailNext.text = DateTimeConverter.longDate(dataDetailMatch[0].dateEvent!!)

        textViewHomeScoreNext.text = dataDetailMatch[0].intHomeScore
        textViewAwayScoreNext.text = dataDetailMatch[0].intAwayScore

        if (dataDetailMatch[0].intHomeShots == null || dataDetailMatch[0].intAwayShots == null){
            textViewShotsHomeTeamDetailNext.text = "-"
            textViewShotsAwayTeamDetailNext.text = "-"
        }else{
            textViewShotsHomeTeamDetailNext.text = dataDetailMatch[0].intHomeShots
            textViewShotsAwayTeamDetailNext.text = dataDetailMatch[0].intAwayShots
        }

        textViewGoalHomeTeamDetailNext.text = dataDetailMatch[0].strHomeGoalDetails
        textViewGoalAwayTeamDetailNext.text = dataDetailMatch[0].strAwayGoalDetails

        textViewGKHomeTeamNext.text = dataDetailMatch[0].strHomeLineupGoalkeeper
        textViewGKAwayTeamNext.text = dataDetailMatch[0].strAwayLineupGoalkeeper

        textViewDefendersHomeTeamNext.text = dataDetailMatch[0].strHomeLineupDefense
        textViewDefendersAwayTeamNext.text = dataDetailMatch[0].strAwayLineupDefense

        textViewMidefieldsHomeTeamNext.text = dataDetailMatch[0].strHomeLineupMidfield
        textViewMidefieldsAwayTeamNext.text = dataDetailMatch[0].strAwayLineupMidfield

        textViewForwardsHomeTeamNext.text = dataDetailMatch[0].strHomeLineupForward
        textViewForwardsAwayTeamNext.text = dataDetailMatch[0].strAwayLineupForward

        textViewSubtitutionsHomeTeamNext.text = dataDetailMatch[0].strHomeLineupSubstitutes
        textViewSubtitutionsAwayTeamNext.text = dataDetailMatch[0].strAwayLineupSubstitutes

        textViewYellowCardHomeTeamNext.text = dataDetailMatch[0].strHomeYellowCards
        textViewYellowCardAwayTeamNext.text = dataDetailMatch[0].strAwayYellowCards

        if (dataDetailMatch[0].strHomeRedCards!!.isEmpty() ||  dataDetailMatch[0].strAwayRedCards!!.isEmpty()){
            textViewRedCardsHomeTeamNext.text = "-"
            textViewRedCardsAwayTeamNext.text = "-"
        }else{
            textViewRedCardsHomeTeamNext.text = dataDetailMatch[0].strHomeRedCards
            textViewRedCardsAwayTeamNext.text = dataDetailMatch[0].strAwayRedCards
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}
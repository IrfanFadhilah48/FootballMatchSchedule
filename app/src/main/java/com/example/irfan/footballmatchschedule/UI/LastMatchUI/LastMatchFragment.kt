package com.example.irfan.footballmatchschedule.UI.LastMatchUI

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import com.example.irfan.footballmatchschedule.API.ApiRepository
import com.example.irfan.footballmatchschedule.Adapter.MatchAdapter
import com.example.irfan.footballmatchschedule.Model.EventsLastLeague
import com.example.irfan.footballmatchschedule.R
import com.example.irfan.footballmatchschedule.UI.LastMatchDetailUI.LastMatchDetailActivity
import com.example.irfan.footballmatchschedule.Utils.invisible
import com.example.irfan.footballmatchschedule.Utils.visible
import com.google.gson.Gson
import org.jetbrains.anko.*
import org.jetbrains.anko.support.v4.startActivity
import org.jetbrains.anko.support.v4.toast

class LastMatchFragment : Fragment(), LastMatchView{

    private lateinit var presenter: LastMatchPresenter
    private lateinit var adapter: MatchAdapter
    private lateinit var progressBar: ProgressBar
    private lateinit var recyclerView: RecyclerView
    private var events: MutableList<EventsLastLeague> = mutableListOf()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val viewRoot = inflater.inflate(R.layout.fragment_last_match, container, false)
        recyclerView = viewRoot.find(R.id.recylerview)
        progressBar = viewRoot.find(R.id.progressbar)

        recyclerView.layoutManager = LinearLayoutManager(activity)
        return viewRoot
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setLayout()
    }

    private fun setLayout() {
        presenter = LastMatchPresenter(this, ApiRepository(), Gson())
        adapter = MatchAdapter(events){
            toast("anda memilih ${it.strEvent}")
            startActivity<LastMatchDetailActivity>(LastMatchDetailActivity.INTENT to it)
        }
        presenter.getEventsLast()
        recyclerView.adapter = adapter
    }

    override fun showLoading() {
        progressBar.visible()
        recyclerView.invisible()
    }

    override fun hideLoading() {
        progressBar.invisible()
        recyclerView.visible()
    }

    override fun showEventList(data: List<EventsLastLeague>) {
        events.clear()
        events.addAll(data)
        adapter.notifyDataSetChanged()
    }

}
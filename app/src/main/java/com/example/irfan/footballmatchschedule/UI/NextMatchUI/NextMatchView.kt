package com.example.irfan.footballmatchschedule.UI.NextMatchUI

import com.example.irfan.footballmatchschedule.Model.EventsNextLeague

interface NextMatchView{
    fun showLoading()
    fun hideLoading()
    fun showEventList(data: List<EventsNextLeague>)
}
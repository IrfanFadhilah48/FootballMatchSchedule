package com.example.irfan.footballmatchschedule.Adapter

import android.content.Context
import android.os.Build.VERSION_CODES.N
import android.support.v7.view.menu.ActionMenuItemView
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.example.irfan.footballmatchschedule.Model.EventsNextLeague
import java.util.*

class NextMatchAdapter(private val context: Context, private val items: List<EventsNextLeague>, private val listener: (
    EventsNextLeague) -> Unit): RecyclerView.Adapter<NextMatchAdapter.ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }

}
package com.example.irfan.footballmatchschedule.Adapter

import android.content.Context
import android.support.v7.view.menu.ActionMenuItemView
import android.support.v7.widget.RecyclerView
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.LinearLayout
import com.example.irfan.footballmatchschedule.Model.Events
import com.example.irfan.footballmatchschedule.R
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import java.text.FieldPosition
import org.jetbrains.anko.*

class MatchAdapter(private val context: Context, private val items: List<Events>, private val listener: (
    Events)-> Unit) : RecyclerView.Adapter<MatchAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(EventUI().createView(AnkoContext.create(parent.context, parent)))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    class ViewHolder (itemView : View): RecyclerView.ViewHolder(itemView){

    }

    companion object {

    }
    class EventUI : AnkoComponent<ViewGroup>{
        override fun createView(ui: AnkoContext<ViewGroup>): View {
            return with(ui){
                linearLayout{
                    lparams(width = matchParent, height = wrapContent)
                    padding = dip(16)
                    orientation = LinearLayout.HORIZONTAL

                }
            }
        }

    }
}
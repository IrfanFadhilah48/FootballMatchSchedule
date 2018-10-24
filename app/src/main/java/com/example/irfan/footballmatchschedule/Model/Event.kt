package com.example.irfan.footballmatchschedule.Model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Event(
    var teamId  : String?,
    var strTeam : String?,
    var strTeamBadge : String? = null
) : Parcelable
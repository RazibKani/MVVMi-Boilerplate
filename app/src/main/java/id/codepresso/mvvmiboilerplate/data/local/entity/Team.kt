package id.codepresso.mvvmiboilerplate.data.local.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "football_team")
data class Team(
        @PrimaryKey(autoGenerate = true)
        val uid: Long,
        @SerializedName("idTeam") val idTeam: String,
        @SerializedName("strTeam") val strTeam: String,
        @SerializedName("strTeamBadge") val strTeamBadge: String
)
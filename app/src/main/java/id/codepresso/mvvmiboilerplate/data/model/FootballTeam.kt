package id.codepresso.mvvmiboilerplate.data.model
import com.google.gson.annotations.SerializedName

/**
 * Razib Kani Maulidan
 * 21/07/2018
 */
data class FootballTeam(
    @SerializedName("teams") val teams: List<Team>
)

data class Team(
    @SerializedName("idTeam") val idTeam: String,
    @SerializedName("strTeam") val strTeam: String,
    @SerializedName("strTeamBadge") val strTeamBadge: String
)
package id.codepresso.mvvmiboilerplate.data.model
import com.google.gson.annotations.SerializedName
import id.codepresso.mvvmiboilerplate.data.local.entity.Team

/**
 * Razib Kani Maulidan
 * 21/07/2018
 */
data class FootballTeam(
    @SerializedName("teams") val teams: List<Team>
)
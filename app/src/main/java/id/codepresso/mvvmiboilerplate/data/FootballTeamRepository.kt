package id.codepresso.mvvmiboilerplate.data

import id.codepresso.mvvmiboilerplate.data.local.entity.Team
import io.reactivex.Single

/**
 * Razib Kani Maulidan
 * 21/07/2018
 */
interface FootballTeamRepository {

    fun getFootballTeamApi(teamName: String): Single<List<Team>>

    fun getFootballTeamDb(): Single<List<Team>>

    fun saveFootballTeam(teams: List<Team>)
}
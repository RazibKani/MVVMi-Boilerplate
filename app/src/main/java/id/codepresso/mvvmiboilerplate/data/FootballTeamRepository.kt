package id.codepresso.mvvmiboilerplate.data

import id.codepresso.mvvmiboilerplate.data.model.FootballTeam
import io.reactivex.Flowable

/**
 * Razib Kani Maulidan
 * 21/07/2018
 */
interface FootballTeamRepository {

    fun getFootballTeam(teamName: String): Flowable<FootballTeam>
}
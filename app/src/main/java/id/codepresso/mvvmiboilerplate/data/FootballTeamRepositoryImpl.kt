package id.codepresso.mvvmiboilerplate.data

import id.codepresso.mvvmiboilerplate.data.model.FootballTeam
import id.codepresso.mvvmiboilerplate.data.remote.ApiServices
import io.reactivex.Flowable

/**
 * Razib Kani Maulidan
 * 21/07/2018
 */
class FootballTeamRepositoryImpl(private val apiServices: ApiServices) : FootballTeamRepository {

    override fun getFootballTeam(teamName: String): Flowable<FootballTeam> {
        return apiServices.searchTeams(teamName)
    }
}
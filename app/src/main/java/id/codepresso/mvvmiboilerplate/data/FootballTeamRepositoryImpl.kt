package id.codepresso.mvvmiboilerplate.data

import id.codepresso.mvvmiboilerplate.data.local.dao.TeamDao
import id.codepresso.mvvmiboilerplate.data.local.entity.Team
import id.codepresso.mvvmiboilerplate.data.remote.ApiServices
import io.reactivex.Single

/**
 * Razib Kani Maulidan
 * 21/07/2018
 */
class FootballTeamRepositoryImpl(private val apiServices: ApiServices,
                                 private val teamDao: TeamDao): FootballTeamRepository {

    override fun getFootballTeamApi(teamName: String): Single<List<Team>> {
        return apiServices.searchTeams(teamName)
                .map { it.teams }
    }

    override fun getFootballTeamDb(): Single<List<Team>> {
        return teamDao.getTeam()
    }

    override fun saveFootballTeam(teams: List<Team>) {
        for (team in teams) {
            teamDao.insertTeam(team)
        }
    }
}
package id.codepresso.mvvmiboilerplate.presentation

import id.codepresso.mvvmiboilerplate.data.FootballTeamRepositoryImpl
import id.codepresso.mvvmiboilerplate.data.local.entity.Team
import io.reactivex.Single

/**
 * Razib Kani Maulidan
 * 21/07/2018
 */
class FootballTeamInteractor(private val repository: FootballTeamRepositoryImpl)
    : FootballTeamContract.Interactor {

    override fun getFootballTeam(teamName: String): Single<List<Team>> {
        return Single
                .concat(diskWithCache, getNetworkWithSave(teamName))
                .filter { teams -> teams.isNotEmpty() }
                .first(ArrayList())
    }

    private fun getNetworkWithSave(teamName: String): Single<List<Team>> {
        return repository.getFootballTeamApi(teamName)
                .doOnSuccess {
                    repository.saveFootballTeam(it)
                }
    }

    private var diskWithCache = repository.getFootballTeamDb()
}
package id.codepresso.mvvmiboilerplate.presentation

import id.codepresso.mvvmiboilerplate.data.FootballTeamRepositoryImpl
import id.codepresso.mvvmiboilerplate.data.model.FootballTeam
import io.reactivex.Flowable

/**
 * Razib Kani Maulidan
 * 21/07/2018
 */
class FootballTeamInteractor(private val repository: FootballTeamRepositoryImpl)
    : FootballTeamContract.Interactor {

    override fun getFootballTeam(teamName: String): Flowable<FootballTeam> {
        return repository.getFootballTeam(teamName)
    }
}
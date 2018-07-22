package id.codepresso.mvvmiboilerplate.presentation

import id.codepresso.mvvmiboilerplate.data.local.entity.Team
import io.reactivex.Single

/**
 * Razib Kani Maulidan
 * 21/07/2018
 */
interface FootballTeamContract {

    interface View {

        fun observeLoading(isLoading: Boolean?)

        fun observeError(error: Throwable?)

        fun observeFootballTeam(team: Team?)
    }

    interface ViewModel {

        fun getFootballTeam(teamName: String)
    }

    interface Interactor {

        fun getFootballTeam(teamName: String): Single<List<Team>>
    }
}
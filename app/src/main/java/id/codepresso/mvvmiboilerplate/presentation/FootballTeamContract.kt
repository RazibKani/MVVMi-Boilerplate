package id.codepresso.mvvmiboilerplate.presentation

import id.codepresso.mvvmiboilerplate.data.model.FootballTeam
import id.codepresso.mvvmiboilerplate.data.model.Team
import io.reactivex.Flowable

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

        fun getFootballTeam(teamName: String): Flowable<FootballTeam>
    }
}
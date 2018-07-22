package id.codepresso.mvvmiboilerplate.presentation

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import id.codepresso.mvvmiboilerplate.data.local.entity.Team
import id.codepresso.mvvmiboilerplate.util.SchedulersProvider

/**
 * Razib Kani Maulidan
 * 21/07/2018
 */
class FootballTeamViewModel(private val interactor: FootballTeamInteractor,
                            private val schedulers: SchedulersProvider):
        ViewModel(), FootballTeamContract.ViewModel {

    val isLoading = MutableLiveData<Boolean>()
    val isError = MutableLiveData<Throwable>()
    val footballTeam = MutableLiveData<Team>()

    override fun getFootballTeam(teamName: String) {
        isLoading.postValue(true)
        interactor.getFootballTeam(teamName)
                .observeOn(schedulers.ui())
                .subscribeOn(schedulers.io())
                .subscribe({ result ->
                    isLoading.postValue(false)
                    footballTeam.postValue(result[0])
                }, { error ->
                    isLoading.postValue(false)
                    isError.postValue(error)
                })
    }
}
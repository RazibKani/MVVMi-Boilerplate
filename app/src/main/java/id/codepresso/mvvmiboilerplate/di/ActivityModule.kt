package id.codepresso.mvvmiboilerplate.di

import id.codepresso.mvvmiboilerplate.presentation.FootballTeamInteractor
import id.codepresso.mvvmiboilerplate.presentation.FootballTeamViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val activityModule = module {

    module(Scope.FOOTBALL_TEAM) {
        single { FootballTeamInteractor(get()) }
        viewModel { FootballTeamViewModel(get(), get()) }
    }
}
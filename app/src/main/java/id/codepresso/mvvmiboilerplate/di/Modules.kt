package id.codepresso.mvvmiboilerplate.di

import id.codepresso.mvvmiboilerplate.data.FootballTeamRepositoryImpl
import id.codepresso.mvvmiboilerplate.data.remote.ApiServices
import id.codepresso.mvvmiboilerplate.presentation.FootballTeamInteractor
import id.codepresso.mvvmiboilerplate.presentation.FootballTeamViewModel
import id.codepresso.mvvmiboilerplate.util.SchedulersProvider
import org.koin.android.architecture.ext.viewModel
import org.koin.dsl.module.applicationContext

/**
 * Razib Kani Maulidan
 * 21/07/2018
 */
val appModule = applicationContext {

    factory { FootballTeamInteractor(get()) }
    viewModel { FootballTeamViewModel(get(), get()) }

    bean { ApiServices.create() }
    bean { SchedulersProvider() }
    bean { FootballTeamRepositoryImpl(get()) }
}
package id.codepresso.mvvmiboilerplate.di

import android.arch.persistence.room.Room
import id.codepresso.mvvmiboilerplate.data.FootballTeamRepositoryImpl
import id.codepresso.mvvmiboilerplate.data.local.MVVMiDb
import id.codepresso.mvvmiboilerplate.data.remote.ApiServices
import id.codepresso.mvvmiboilerplate.presentation.FootballTeamInteractor
import id.codepresso.mvvmiboilerplate.presentation.FootballTeamViewModel
import id.codepresso.mvvmiboilerplate.util.Config
import id.codepresso.mvvmiboilerplate.util.SchedulersProvider
import org.koin.android.architecture.ext.viewModel
import org.koin.android.ext.koin.androidApplication
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
    bean { FootballTeamRepositoryImpl(get(), get()) }

    bean {
        Room.databaseBuilder(androidApplication(), MVVMiDb::class.java, Config.DB_NAME)
                .build()
    }
    bean { get<MVVMiDb>().teamDao() }
}
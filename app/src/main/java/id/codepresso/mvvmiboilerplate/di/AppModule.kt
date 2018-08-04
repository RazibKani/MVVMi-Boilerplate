package id.codepresso.mvvmiboilerplate.di

import android.arch.persistence.room.Room
import id.codepresso.mvvmiboilerplate.data.FootballTeamRepositoryImpl
import id.codepresso.mvvmiboilerplate.data.local.MVVMiDb
import id.codepresso.mvvmiboilerplate.data.remote.ApiServices
import id.codepresso.mvvmiboilerplate.util.Config
import id.codepresso.mvvmiboilerplate.util.SchedulersProvider
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module.module

/**
 * Razib Kani Maulidan
 * 21/07/2018
 */
val appModule = module {

    single { ApiServices.create() }
    single { SchedulersProvider() }
    single { FootballTeamRepositoryImpl(get(), get()) }

    single {
        Room.databaseBuilder(androidContext(), MVVMiDb::class.java, Config.DB_NAME)
                .build()
    }
    single { get<MVVMiDb>().teamDao() }
}
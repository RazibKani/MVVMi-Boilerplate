package id.codepresso.mvvmiboilerplate

import android.app.Application
import id.codepresso.mvvmiboilerplate.di.appModule
import org.koin.android.ext.android.startKoin

/**
 * Razib Kani Maulidan
 * 21/07/2018
 */
class MVVMiBoilerplateApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin(this, listOf(appModule))
    }
}
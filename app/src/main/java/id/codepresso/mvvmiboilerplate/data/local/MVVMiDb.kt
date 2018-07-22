package id.codepresso.mvvmiboilerplate.data.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import id.codepresso.mvvmiboilerplate.data.local.dao.TeamDao
import id.codepresso.mvvmiboilerplate.data.local.entity.Team

@Database(entities = [Team::class], version = 1)
abstract class MVVMiDb: RoomDatabase() {

    abstract fun teamDao(): TeamDao
}
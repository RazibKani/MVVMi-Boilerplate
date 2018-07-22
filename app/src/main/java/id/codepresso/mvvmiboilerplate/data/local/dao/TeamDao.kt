package id.codepresso.mvvmiboilerplate.data.local.dao

import android.arch.persistence.room.*
import id.codepresso.mvvmiboilerplate.data.local.entity.Team
import io.reactivex.Single

@Dao
interface TeamDao {

    @Query("SELECT * FROM football_team")
    fun getTeam(): Single<List<Team>>

    @Insert
    fun insertTeam(vararg team: Team)

    @Update
    fun updateTeam(vararg team: Team)

    @Delete
    fun deleteTeam(team: Team)
}
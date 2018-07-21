package id.codepresso.mvvmiboilerplate.data.remote

import com.google.gson.Gson
import id.codepresso.mvvmiboilerplate.data.model.FootballTeam
import io.reactivex.Flowable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Razib Kani Maulidan
 * 21/07/2018
 */
interface ApiServices {

    @GET("searchteams.php")
    fun searchTeams(@Query("t") teamName: String): Flowable<FootballTeam>

    companion object Factory {
        fun create(): ApiServices {
            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(Gson()))
                    .baseUrl("https://www.thesportsdb.com/api/v1/json/1/")
                    .build()

            return retrofit.create(ApiServices::class.java)
        }
    }
}
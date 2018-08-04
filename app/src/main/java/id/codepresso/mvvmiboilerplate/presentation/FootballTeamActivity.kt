package id.codepresso.mvvmiboilerplate.presentation

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import id.codepresso.mvvmiboilerplate.R
import id.codepresso.mvvmiboilerplate.data.local.entity.Team
import id.codepresso.mvvmiboilerplate.di.Scope
import id.codepresso.mvvmiboilerplate.util.Config
import id.codepresso.mvvmiboilerplate.util.hide
import id.codepresso.mvvmiboilerplate.util.loadImage
import id.codepresso.mvvmiboilerplate.util.visible
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast
import org.koin.android.scope.ext.android.scopedWith
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * Razib Kani Maulidan
 * 21/07/2018
 */
class FootballTeamActivity : AppCompatActivity(), FootballTeamContract.View {

    private val viewModel by viewModel<FootballTeamViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        scopedWith(Scope.FOOTBALL_TEAM)

        viewModel.apply {
            isLoading.observe(this@FootballTeamActivity, Observer<Boolean> { isLoading -> observeLoading(isLoading) })
            isError.observe(this@FootballTeamActivity, Observer<Throwable> { error -> observeError(error) })
            footballTeam.observe(this@FootballTeamActivity, Observer<Team> { team -> observeFootballTeam(team) })
        }

        viewModel.getFootballTeam(Config.TEAM_NAME)
    }

    override fun observeLoading(isLoading: Boolean?) {
        isLoading?.let {
            if (it) {
                pbLoading.visible()
            } else {
                pbLoading.hide()
            }
        }
    }

    override fun observeError(error: Throwable?) {
        error?.let { toast(it.message.toString()) }
    }

    override fun observeFootballTeam(team: Team?) {
        team?.let {
            ivTeamLogo.loadImage(it.strTeamBadge)
            tvTeamName.text = it.strTeam
        }
    }
}
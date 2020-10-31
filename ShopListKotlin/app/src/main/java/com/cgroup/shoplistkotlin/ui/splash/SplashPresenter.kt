package pro.midev.gurmanica.ui.splash

import android.content.Context
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpView
import com.cgroup.shoplistkotlin.Screens
import com.cgroup.shoplistkotlin.common.CiceroneHolder
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import org.koin.core.inject
import pro.midev.gurmanica.common.base.BasePresenter
import ru.terrakok.cicerone.Router
import java.util.concurrent.TimeUnit
import java.util.logging.Level
import java.util.logging.Logger

@InjectViewState
class SplashPresenter : BasePresenter<MvpView>() {

    private val context: Context by inject()
    private val navigationHolder: CiceroneHolder by inject()

    private val router: Router?
        get() = navigationHolder.currentRouter

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        start()
    }

    private fun start() {
        Single
            .timer(2, TimeUnit.SECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(
                {
                        router?.replaceScreen(Screens.FlowList)
                },
                {
                    Logger.getLogger("shoplog").log(Level.INFO, "error in SplashPresenter")
                }
            ).connect()
    }

    fun back() {
        router?.exit()
    }
}
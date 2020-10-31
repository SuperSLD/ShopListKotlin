package pro.midev.gurmanica.ui.global

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpView
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import org.koin.core.inject
import pro.midev.gurmanica.common.base.BasePresenter


@InjectViewState
class GlobalPresenter : BasePresenter<GlobalView>() {
}
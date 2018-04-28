package np.com.sagardevkota.daggertemplate.ui.base

import np.com.sagardevkota.daggertemplate.ui.main.MainMvpView

import javax.inject.Inject

/**
 * Every presenter in the app must either implement this interface or extend BasePresenter
 * indicating the MvpView type that wants to be attached with.
 */
interface Presenter<V : MvpView> {

    fun attachView(mvpView: V)

    fun detachView()

    /**
     * Created by Dell on 10/18/2016.
     */
    class MainPresenter @Inject
    constructor() : BasePresenter<MainMvpView>() {
        private val TAG = javaClass.name

        override fun attachView(mvpView: MainMvpView) {
            super.attachView(mvpView)
        }

        override fun detachView() {
            super.detachView()
        }
    }
}

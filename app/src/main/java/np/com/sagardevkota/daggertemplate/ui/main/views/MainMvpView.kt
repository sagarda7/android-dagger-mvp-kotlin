package np.com.sagardevkota.daggertemplate.ui.main.views

import np.com.sagardevkota.daggertemplate.ui.base.MvpView

/**
 * Created by Dell on 10/18/2016.
 * All activity UI update functions here which will be called back to Related Activity
 */
interface MainMvpView : MvpView {
    fun showName(name: String)
    fun showGithubNames(name: String)
}

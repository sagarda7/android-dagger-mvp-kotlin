package np.com.sagardevkota.daggertemplate.ui.main.fragments.home


import np.com.sagardevkota.daggertemplate.ui.base.MvpView

/**
 * Created by Dell on 10/18/2016.
 * All activity UI update functions here which will be called back to Related Activity
 */
interface HomeFragmentMvpView : MvpView {
    fun showData(s: String)
}

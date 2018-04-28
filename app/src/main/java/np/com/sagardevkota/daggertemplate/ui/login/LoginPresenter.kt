package np.com.sagardevkota.daggertemplate.ui.login

import javax.inject.Inject

import np.com.sagardevkota.daggertemplate.data.remote.ApiInterface
import np.com.sagardevkota.daggertemplate.ui.base.BasePresenter

/**
 * Created by Dell on 10/18/2016.
 */
class LoginPresenter @Inject
constructor() : BasePresenter<LoginMvpView>() {
    private val TAG = javaClass.name

    @Inject lateinit var apiInterface: ApiInterface

    override fun attachView(mvpView: LoginMvpView) {
        super.attachView(mvpView)
    }

    override fun detachView() {
        super.detachView()
    }


    fun checkLogin(username: String, password: String) {
        // make network call or get dtat from model with then if success fire view callback
        mvpView!!.onLoginSuccess()
        /* if(username.equals("sagar@yahoo.com") && password.equals("test")){
            getMvpView().onLoginSuccess();
        }
        else {
            getMvpView().onLoginError();
        }*/

    }


}

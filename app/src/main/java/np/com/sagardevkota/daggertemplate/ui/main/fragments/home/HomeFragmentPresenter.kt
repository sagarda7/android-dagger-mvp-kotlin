package np.com.sagardevkota.daggertemplate.ui.main.fragments.home


import javax.inject.Inject

import np.com.sagardevkota.daggertemplate.data.remote.ApiInterface
import np.com.sagardevkota.daggertemplate.ui.base.BasePresenter

/**
 * Created by Dell on 12/20/2016.
 */

class HomeFragmentPresenter @Inject
constructor() : BasePresenter<HomeFragmentMvpView>() {
    private val TAG = javaClass.name
    @Inject
    lateinit var apiInterface: ApiInterface

    override fun attachView(mvpView: HomeFragmentMvpView) {
        super.attachView(mvpView)
    }

    override fun detachView() {
        super.detachView()
    }


    /*public void checkLogin(){
        Observable<LoginResponse> call = apiInterface.login("hari@lavaprotocols.com","3a5874478fb528fb567e3fdebc559436");
        ReactiveRequestHandler.performAsync(call, new ReactiveRequestHandler.RetroReactiveCallback<LoginResponse>() {
            @Override
            public void onComplete(LoginResponse response) {

                //getMvpView().showGithubNames(data);
                Log.d(TAG,response.getStatus().toString()+" is response");
            }

            @Override
            public void onError(HttpException ex) {
                Log.d(TAG,ex.message());
            }
        });
    }*/


    fun loadData() {
        mvpView?.showData("This is home and sagar")
    }
}
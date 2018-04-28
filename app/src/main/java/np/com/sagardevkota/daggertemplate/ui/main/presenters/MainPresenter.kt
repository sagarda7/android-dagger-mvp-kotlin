package np.com.sagardevkota.daggertemplate.ui.main.presenters

import android.content.Context

import np.com.sagardevkota.daggertemplate.data.models.Repository
import np.com.sagardevkota.daggertemplate.data.remote.ApiInterface
import np.com.sagardevkota.daggertemplate.data.remote.ReactiveRequestHandler
import np.com.sagardevkota.daggertemplate.ui.base.BasePresenter

import java.util.ArrayList

import javax.inject.Inject

import np.com.sagardevkota.daggertemplate.ui.main.views.MainMvpView
import retrofit2.adapter.rxjava.HttpException

/**
 * Created by Dell on 10/18/2016.
 */
class MainPresenter @Inject
constructor() : BasePresenter<MainMvpView>() {
    private val TAG = javaClass.name
    @Inject
    lateinit var apiInterface: ApiInterface

    override fun attachView(mvpView: MainMvpView) {
        super.attachView(mvpView)
    }

    override fun detachView() {
        super.detachView()
    }

    fun loadData(context: Context) {
        //get data from modal and present to view
        mvpView?.showName("Sagar")
    }

    fun fetchDataFromGithub() {
        val call = apiInterface.getRepository("sagarda7")
        ReactiveRequestHandler.performAsync(call, object : ReactiveRequestHandler.RetroReactiveCallback<ArrayList<Repository>> {
            override fun onComplete(response: ArrayList<Repository>) {
                var data = ""
                for (repo in response) {
                    data += repo.name + ","
                }
                mvpView!!.showGithubNames(data)
            }

            override fun onError(ex: HttpException) {

            }
        })
    }


}

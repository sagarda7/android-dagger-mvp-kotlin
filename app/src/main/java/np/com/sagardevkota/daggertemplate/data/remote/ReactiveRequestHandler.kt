package np.com.sagardevkota.daggertemplate.data.remote

import retrofit2.adapter.rxjava.HttpException
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.functions.Action1
import rx.schedulers.Schedulers

/**
 * Created by Dell on 10/6/2016.
 */
object ReactiveRequestHandler {

    fun <T> performAsync(call: Observable<T>, callback: RetroReactiveCallback<T>) {
        val response = Action1<T> { t -> callback.onComplete(t) }

        val error = Action1<Throwable> { t ->
            if (t is HttpException) {
                callback.onError(t)
            }
        }

        call.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response, error)

    }


    interface RetroReactiveCallback<T> {
        fun onComplete(response: T)
        fun onError(ex: HttpException)
    }


}
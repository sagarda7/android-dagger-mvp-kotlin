package np.com.sagardevkota.daggertemplate.data.remote

import java.util.ArrayList

import np.com.sagardevkota.daggertemplate.data.models.Repository

import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path
import rx.Observable

/**
 * Created by HP on 10/3/2016.
 */
interface ApiInterface {
    @GET("/users/{user}/repos")
    fun getRepository(@Path("user") userName: String): Observable<ArrayList<Repository>>


    /*@POST("/api/v1/login")
    Observable<LoginResponse> login(@Header("username") String email, @Header("password") String password);*/


}

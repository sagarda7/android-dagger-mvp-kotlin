package np.com.sagardevkota.daggertemplate.injection.modules

import javax.inject.Singleton

import dagger.Module
import dagger.Provides
import np.com.sagardevkota.daggertemplate.data.remote.ApiInterface
import retrofit2.Retrofit

/**
 * Created by HP on 10/3/2016.
 */
@Module
class ApiModule {
    @Provides
    @Singleton
    fun providesApiInterface(retrofit: Retrofit): ApiInterface {
        return retrofit.create(ApiInterface::class.java)
    }
}
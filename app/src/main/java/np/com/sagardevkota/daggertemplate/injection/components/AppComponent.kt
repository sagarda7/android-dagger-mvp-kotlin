package np.com.sagardevkota.daggertemplate.injection.components

import javax.inject.Singleton

import dagger.Component
import np.com.sagardevkota.daggertemplate.MyApplication
import np.com.sagardevkota.daggertemplate.injection.modules.ApiModule
import np.com.sagardevkota.daggertemplate.injection.modules.AppModule
import np.com.sagardevkota.daggertemplate.injection.modules.NetModule
import np.com.sagardevkota.daggertemplate.data.remote.ApiInterface
import np.com.sagardevkota.daggertemplate.data.local.realm.RealmDatabase

/**
 * Created by HP on 10/3/2016.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class, NetModule::class, ApiModule::class))
interface AppComponent {
    fun apiInterface(): ApiInterface  //provided to subcomponents
    fun database(): RealmDatabase
    fun inject(application: MyApplication)

}

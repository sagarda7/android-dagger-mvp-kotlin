package np.com.sagardevkota.daggertemplate

import android.app.Application
import com.facebook.stetho.Stetho
import com.uphyca.stetho_realm.RealmInspectorModulesProvider

//import com.facebook.stetho.Stetho
//import com.uphyca.stetho_realm.RealmInspectorModulesProvider

import np.com.sagardevkota.daggertemplate.injection.Injector
import np.com.sagardevkota.daggertemplate.data.local.realm.RealmDatabase

import javax.inject.Inject


/**
 * Created by HP on 10/3/2016.
 */
class MyApplication : Application() {

    @Inject lateinit var database: RealmDatabase

    override fun onCreate() {
        super.onCreate()
        Injector.initializeApplicationComponent(this)
        Injector.appComponent!!.inject(this)
        database.setup()
        Stetho.initialize(Stetho.newInitializerBuilder(this)
                .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                .enableWebKitInspector(RealmInspectorModulesProvider.builder(this).build())
                .build())
    }


}
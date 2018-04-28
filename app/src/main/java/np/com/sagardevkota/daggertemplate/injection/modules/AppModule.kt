package np.com.sagardevkota.daggertemplate.injection.modules

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

import np.com.sagardevkota.daggertemplate.data.local.realm.RealmDatabase

import javax.inject.Singleton

import dagger.Module
import dagger.Provides

/**
 * Created by HP on 10/3/2016.
 */
@Module
class AppModule(internal var mApplication: Application) {

    @Provides
    @Singleton
    internal fun providesApplication(): Application {
        return mApplication
    }

    // Dagger will only look for methods annotated with @Provides
    @Provides
    @Singleton
    internal fun providesSharedPreferences(application: Application):
    // Application reference must come from AppModule.class
            SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(application)
    }

    @Provides
    @Singleton
    fun applicationContext(): Context {
        return mApplication.applicationContext
    }

    //because database is needed in application scope
    @Provides
    @Singleton
    internal fun providesRealmDatabase(c: Context): RealmDatabase {
        return RealmDatabase(c)
    }

}
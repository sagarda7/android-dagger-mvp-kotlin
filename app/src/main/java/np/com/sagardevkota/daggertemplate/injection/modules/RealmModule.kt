package np.com.sagardevkota.daggertemplate.injection.modules

import dagger.Module
import dagger.Provides
import np.com.sagardevkota.daggertemplate.injection.scopes.PerActivity
import np.com.sagardevkota.daggertemplate.data.local.realm.RealmDatabase

import np.com.sagardevkota.daggertemplate.data.local.realm.RealmRepository

/**
 * Created by Dell on 10/4/2016.
 */

@Module
class RealmModule {

    @Provides
    @PerActivity
    internal fun providesRealmRepository(database: RealmDatabase): RealmRepository {
        return RealmRepository(database)
    }
}

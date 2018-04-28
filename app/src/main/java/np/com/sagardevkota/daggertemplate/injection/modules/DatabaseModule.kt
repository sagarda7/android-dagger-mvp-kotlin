package np.com.sagardevkota.daggertemplate.injection.modules

import android.content.Context

import dagger.Module
import dagger.Provides
import np.com.sagardevkota.daggertemplate.injection.scopes.PerActivity

import np.com.sagardevkota.daggertemplate.data.local.sqllite.DBRepoHelper

/**
 * Created by Dell on 10/4/2016.
 */

@Module
class DatabaseModule {

    @Provides
    @PerActivity
    internal fun providesRepoDB(c: Context): DBRepoHelper {
        return DBRepoHelper(c)
    }
}

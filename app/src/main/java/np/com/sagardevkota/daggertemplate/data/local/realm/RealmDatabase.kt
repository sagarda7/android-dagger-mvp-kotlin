package np.com.sagardevkota.daggertemplate.data.local.realm

import android.content.Context

import javax.inject.Inject
import javax.inject.Singleton

import io.realm.Realm
import io.realm.RealmConfiguration

/**
 * Created by Dell on 10/5/2016.
 */
@Singleton
class RealmDatabase @Inject
constructor(internal var mContext: Context) {

    internal var realmConfiguration: RealmConfiguration? = null

    val realmInstance: Realm
        get() {
            val config = RealmConfiguration.Builder()
                    .deleteRealmIfMigrationNeeded()
                    .build()
            return Realm.getInstance(config)
        }

    fun setup() {
        /*if (realmConfiguration == null) {
            realmConfiguration = new RealmConfiguration.Builder(mContext).build();
            Realm.setDefaultConfiguration(realmConfiguration);
        } else {
            throw new IllegalStateException("database already configured");
        }*/

        Realm.init(mContext)
    }


    fun close() {
        realmInstance.close()
    }
}

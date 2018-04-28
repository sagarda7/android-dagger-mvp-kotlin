package np.com.sagardevkota.daggertemplate.data.local.realm

import android.util.Log

import io.realm.Realm
import np.com.sagardevkota.daggertemplate.data.models.Repository

/**
 * Created by Dell on 10/5/2016.
 */
class RealmRepository constructor(internal var database: RealmDatabase) {
    private var realm: Realm = database.realmInstance

    fun add(repository: Repository) {
        Log.d("DEBUG", "add called in realm")
        /*realm.executeTransaction(object : Realm.Transaction() {
            fun execute(realm: Realm) {
                // Add a person
                val repo = realm.createObject(Repository::class.java)
                repo.name = "Hari"
                repo.fullName = "Hari Bastola"
                repo.description = "Nepal"

            }
        })*/
    }


    fun all(): List<Repository> {
        return realm.where(Repository::class.java).findAll()
    }
}

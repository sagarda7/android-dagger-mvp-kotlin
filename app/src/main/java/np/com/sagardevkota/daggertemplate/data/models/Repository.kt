package np.com.sagardevkota.daggertemplate.data.models

import io.realm.RealmObject
import io.realm.annotations.Required

/**
 * Created by HP on 10/3/2016.
 */
open class Repository (

    @Required
    var name: String? = null,
    var fullName: String? = null,
    var description: String ?= null
) :  RealmObject()

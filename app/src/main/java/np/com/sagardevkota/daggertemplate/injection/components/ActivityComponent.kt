package np.com.sagardevkota.daggertemplate.injection.components

import np.com.sagardevkota.daggertemplate.injection.modules.ActivityModule
import np.com.sagardevkota.daggertemplate.injection.modules.DatabaseModule
import np.com.sagardevkota.daggertemplate.injection.modules.RealmModule
import np.com.sagardevkota.daggertemplate.injection.scopes.PerActivity
import np.com.sagardevkota.daggertemplate.ui.login.LoginActivity
import np.com.sagardevkota.daggertemplate.ui.main.MainActivity

import dagger.Component

/**
 * Created by HP on 10/22/2016.
 */

@PerActivity
@Component(dependencies = arrayOf(AppComponent::class), modules = arrayOf(ActivityModule::class, RealmModule::class, DatabaseModule::class))
interface ActivityComponent {
    fun inject(loginActivity: LoginActivity)
    fun inject(loginActivity: MainActivity)

}


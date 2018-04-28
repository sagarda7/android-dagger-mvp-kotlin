package np.com.sagardevkota.daggertemplate.injection.components


import dagger.Component
import np.com.sagardevkota.daggertemplate.injection.modules.DatabaseModule
import np.com.sagardevkota.daggertemplate.injection.modules.FragmentModule
import np.com.sagardevkota.daggertemplate.injection.modules.RealmModule
import np.com.sagardevkota.daggertemplate.injection.scopes.PerFragment
import np.com.sagardevkota.daggertemplate.ui.main.fragments.HomeFragment

/**
 * Created by HP on 10/22/2016.
 */

@PerFragment
@Component(dependencies = arrayOf(AppComponent::class), modules = arrayOf(FragmentModule::class, RealmModule::class, DatabaseModule::class))
interface FragmentComponent {
    fun inject(homeFragment: HomeFragment)


}


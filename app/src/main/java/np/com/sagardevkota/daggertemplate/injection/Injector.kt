package np.com.sagardevkota.daggertemplate.injection


import np.com.sagardevkota.daggertemplate.MyApplication
import np.com.sagardevkota.daggertemplate.common.Const
import np.com.sagardevkota.daggertemplate.injection.components.ActivityComponent
import np.com.sagardevkota.daggertemplate.injection.components.AppComponent
import np.com.sagardevkota.daggertemplate.injection.components.DaggerActivityComponent
import np.com.sagardevkota.daggertemplate.injection.components.DaggerAppComponent
import np.com.sagardevkota.daggertemplate.injection.components.DaggerFragmentComponent
import np.com.sagardevkota.daggertemplate.injection.components.FragmentComponent
import np.com.sagardevkota.daggertemplate.injection.modules.ActivityModule
import np.com.sagardevkota.daggertemplate.injection.modules.ApiModule
import np.com.sagardevkota.daggertemplate.injection.modules.AppModule
import np.com.sagardevkota.daggertemplate.injection.modules.DatabaseModule
import np.com.sagardevkota.daggertemplate.injection.modules.FragmentModule
import np.com.sagardevkota.daggertemplate.injection.modules.NetModule
import np.com.sagardevkota.daggertemplate.injection.modules.RealmModule
import np.com.sagardevkota.daggertemplate.ui.base.BaseActivity
import np.com.sagardevkota.daggertemplate.ui.base.BaseFragment

/**
 * Created by Dell on 10/5/2016.
 */
object Injector {

    var appComponent: AppComponent? = null
        private set
    var activityComponent: ActivityComponent? = null
        private set
    var fragmentComponent: FragmentComponent? = null
        private set

    fun initializeApplicationComponent(application: MyApplication) {
        appComponent = DaggerAppComponent.builder()
                // list of modules that are part of this component need to be created here too
                .appModule(AppModule(application))
                .netModule(NetModule(application, Const.API_URL))
                .apiModule(ApiModule())
                .build()
    }

    fun initialiseActivityComponent(activity: BaseActivity) {
        activityComponent = DaggerActivityComponent.builder()
                .appComponent(appComponent)
                // list of modules that are part of this component need to be created here too
                .activityModule(ActivityModule(activity))
                .databaseModule(DatabaseModule())
                .realmModule(RealmModule())
                .build()
    }

    fun initialiseFragmentComponent(fragment: BaseFragment) {
        fragmentComponent = DaggerFragmentComponent.builder()
                .appComponent(appComponent)
                // list of modules that are part of this component need to be created here too
                .fragmentModule(FragmentModule(fragment))
                .build()
    }


}

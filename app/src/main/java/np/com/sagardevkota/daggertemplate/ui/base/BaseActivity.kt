package np.com.sagardevkota.daggertemplate.ui.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

import np.com.sagardevkota.daggertemplate.injection.Injector
import np.com.sagardevkota.daggertemplate.injection.components.ActivityComponent

/**
 * Created by Dell on 10/18/2016.
 */
open class BaseActivity : AppCompatActivity() {


    val activityComponent: ActivityComponent?
        get() = Injector.activityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Injector.initialiseActivityComponent(this)
    }

}

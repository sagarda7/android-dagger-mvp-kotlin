package np.com.sagardevkota.daggertemplate.ui.base

import android.support.v4.app.Fragment

import np.com.sagardevkota.daggertemplate.injection.Injector
import np.com.sagardevkota.daggertemplate.injection.components.FragmentComponent

/**
 * Created by Dell on 10/18/2016.
 */
open class BaseFragment : Fragment() {


    val fragmentComponent: FragmentComponent?
        get() {
            Injector.initialiseFragmentComponent(this)
            return Injector.fragmentComponent
        }


}

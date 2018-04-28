package np.com.sagardevkota.daggertemplate.injection.modules

/**
 * Created by HP on 12/19/2016.
 */

import android.content.Context
import android.support.v4.app.Fragment


import dagger.Module
import dagger.Provides
import np.com.sagardevkota.daggertemplate.injection.scopes.PerFragment

@Module
class FragmentModule(private val mFragment: Fragment) {

    @Provides
    internal fun provideFragment(): Fragment {
        return mFragment
    }

    @Provides
    @PerFragment
    internal fun providesContext(): Context? {
        return mFragment.context
    }

    /* @Provides
    @PerFragment
    TaskListAdapter providesTaskListAdapter(Context c) {
        return new TaskListAdapter(c);
    }*/

}

package np.com.sagardevkota.daggertemplate.injection.modules

import android.app.Activity
import android.content.Context

import np.com.sagardevkota.daggertemplate.injection.scopes.PerActivity
import np.com.sagardevkota.daggertemplate.ui.views.CustomProgressDialog
import np.com.sagardevkota.daggertemplate.utils.formvalidator.FormValidator

import dagger.Module
import dagger.Provides

/**
 * Created by HP on 10/22/2016.
 */

@Module
class ActivityModule(private val mActivity: Activity) {

    @Provides
    internal fun provideActivity(): Activity {
        return mActivity
    }

    @Provides
    internal fun providesContext(): Context {
        return mActivity
    }

    @Provides
    @PerActivity
    internal fun provideFormValidator(): FormValidator {
        return FormValidator()
    }

    @Provides
    @PerActivity
    internal fun providesCustomProgressDialog(c: Context): CustomProgressDialog {
        return CustomProgressDialog(c)
    }
}
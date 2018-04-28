package np.com.sagardevkota.daggertemplate.ui.login

import android.content.Intent
import android.os.Build
import android.support.design.widget.Snackbar
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.EditText
import android.widget.TextView

import com.tealbox.app.R

import np.com.sagardevkota.daggertemplate.ui.base.BaseActivity
import np.com.sagardevkota.daggertemplate.ui.main.MainActivity
import np.com.sagardevkota.daggertemplate.ui.views.CustomProgressDialog
import np.com.sagardevkota.daggertemplate.utils.formvalidator.FormValidator
import np.com.sagardevkota.daggertemplate.utils.formvalidator.ValidationRule

import javax.inject.Inject

import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick

class LoginActivity : BaseActivity(), LoginMvpView {

    @Inject
    lateinit var mPresenter: LoginPresenter

    @Inject
    lateinit var validator: FormValidator

    @Inject
    lateinit var progress: CustomProgressDialog

    @BindView(R.id.txt_act_login_email) @JvmField
    internal var email: EditText? = null

    @BindView(R.id.txt_act_login_password) @JvmField
    internal var password: EditText? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        activityComponent!!.inject(this)
        ButterKnife.bind(this)
        mPresenter.attachView(this)
    }

    override fun onLoginSuccess() {
        progress.hide()
        val i = Intent(this, MainActivity::class.java)
        startActivity(i)
        finish()
    }

    override fun onLoginError() {
        progress.hide()
        showResponse("Login Error, Credentials wrong")
    }

    override fun onNetworkError() {
        showResponse("Network Error, Please check connection.")
        progress.hide()
    }

    @OnClick(R.id.btn_act_login_login)
    internal fun loginClicked(v: View) {
        val valid = validator
                .add(
                        ValidationRule(email)
                                .add(ValidationRule.EMAIL, "Invalid Email")
                )
                .add(ValidationRule(password)
                        .add(ValidationRule.REQUIRED, "Password is required")
                ).validate()

        //if(!valid) return;
        progress.show()
        mPresenter.checkLogin(email?.text.toString(), password?.text.toString())

    }

    internal fun showResponse(message: String) {
        val mSnackbar = Snackbar.make(password!!, message, Snackbar.LENGTH_LONG)
        // get snackbar view
        val mView = mSnackbar.view
        // get textview inside snackbar view
        val mTextView = mView.findViewById<View>(android.support.design.R.id.snackbar_text) as TextView
        // set text to center
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1)
            mTextView.textAlignment = View.TEXT_ALIGNMENT_CENTER
        else
            mTextView.gravity = Gravity.CENTER_HORIZONTAL

        mSnackbar.show()
    }
}

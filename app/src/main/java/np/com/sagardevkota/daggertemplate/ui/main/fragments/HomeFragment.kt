package np.com.sagardevkota.daggertemplate.ui.main.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.tealbox.app.R

import javax.inject.Inject

import butterknife.BindView
import butterknife.ButterKnife
import np.com.sagardevkota.daggertemplate.ui.base.BaseFragment
import np.com.sagardevkota.daggertemplate.ui.main.presenters.HomeFragmentPresenter
import np.com.sagardevkota.daggertemplate.ui.main.views.HomeFragmentMvpView

/**
 * Created by Dell on 12/20/2016.
 */

class HomeFragment @Inject
constructor() : BaseFragment(), HomeFragmentMvpView {
    @Inject
    lateinit var mPresenter: HomeFragmentPresenter

    @BindView(R.id.text_fragment_main_home_data) @JvmField
    internal var txtData: TextView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        fragmentComponent!!.inject(this)
        val v = inflater.inflate(R.layout.fragment_home, container, false)
        ButterKnife.bind(this, v)

        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mPresenter!!.attachView(this)
        mPresenter!!.loadData()
    }

    override fun onResume() {
        super.onResume()
    }


    override fun showData(s: String) {
        txtData!!.text = s
    }


}

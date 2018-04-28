package np.com.sagardevkota.daggertemplate.ui.main

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View

import com.tealbox.app.R

import np.com.sagardevkota.daggertemplate.ui.base.BaseActivity
import np.com.sagardevkota.daggertemplate.ui.main.fragments.home.HomeFragment

import javax.inject.Inject

/**
 * Created by Dell on 10/18/2016.
 */
class MainActivity : BaseActivity(), MainMvpView, NavigationView.OnNavigationItemSelectedListener {

    @Inject
    lateinit var mMainPresenter: MainPresenter

    @Inject
    lateinit var homeFragment: HomeFragment

    //TextView txtName;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        activityComponent?.inject(this)

        //txtName = (TextView) findViewById(R.id.txt_act_main_name);
        mMainPresenter.attachView(this)
        mMainPresenter.loadData(this)

        val fab = findViewById<View>(R.id.fab) as FloatingActionButton
        fab.setOnClickListener { mMainPresenter.fetchDataFromGithub() }


        val drawer = findViewById<View>(R.id.drawer_layout) as DrawerLayout
        val toggle = ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer.setDrawerListener(toggle)
        toggle.syncState()

        val navigationView = findViewById<View>(R.id.nav_view) as NavigationView
        navigationView.setNavigationItemSelectedListener(this)

        setFragment(homeFragment)

    }


    override fun onBackPressed() {
        val drawer = findViewById<View>(R.id.drawer_layout) as DrawerLayout
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId


        return if (id == R.id.action_settings) {
            true
        } else super.onOptionsItemSelected(item)

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        val id = item.itemId

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        val drawer = findViewById<View>(R.id.drawer_layout) as DrawerLayout
        drawer.closeDrawer(GravityCompat.START)
        return true
    }


    override fun onDestroy() {
        super.onDestroy()
        mMainPresenter.detachView()
    }

    override fun showName(name: String) {
        // txtName.setText(name);
    }

    override fun showGithubNames(name: String) {
        Log.d("names", name)
    }

    internal fun setFragment(fragment: Fragment?) {

        // Add the fragment to the 'fragment_container' FrameLayout
        supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment).commit()
    }
}

package com.saif.truckitin.ui.activity.mainActivity

import android.content.res.Configuration
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.fragment.NavHostFragment
import com.saif.truckitin.BR
import com.saif.truckitin.R
import com.saif.truckitin.baseclasses.BaseActivity
import com.saif.truckitin.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    override val viewModel: Class<MainViewModel>
        get() = MainViewModel::class.java

    override val layoutId: Int
        get() = R.layout.activity_main

    override val bindingVariable: Int
        get() = BR.viewModel

    lateinit var progress_bar: ProgressBar

    private val navController by lazy {
        (supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment).navController
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initialising()
    }

    private fun initialising() {
        progress_bar = findViewById(R.id.progress_bar)
    }

    open fun showProgressBar() {
        progress_bar.visibility = View.VISIBLE
    }

    open fun hideProgressBar() {
        progress_bar.visibility = View.GONE
    }

    override fun onBackPressed() {
        super.onBackPressed()

    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        /*
        * Setting Night Mode
        * */
        return if (item.itemId == R.id.night_menu) {
            val mode = if ((resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK) ==
                Configuration.UI_MODE_NIGHT_NO
            ) {
                AppCompatDelegate.MODE_NIGHT_YES
            } else {
                AppCompatDelegate.MODE_NIGHT_AUTO_BATTERY
            }
            AppCompatDelegate.setDefaultNightMode(mode)

            true
        } else super.onOptionsItemSelected(item)
    }
}
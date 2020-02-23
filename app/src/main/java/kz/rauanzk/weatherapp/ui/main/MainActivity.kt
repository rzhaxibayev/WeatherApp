package kz.rauanzk.weatherapp.ui.main

import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import kotlinx.android.synthetic.main.activity_main.*
import kz.rauanzk.weatherapp.R
import kz.rauanzk.weatherapp.ui.base.BaseActivity

class MainActivity : BaseActivity() {

    private val navController by lazy { findNavController(R.id.activityNavigation) }

    private val appBarConfiguration by lazy {
        AppBarConfiguration(navController.graph)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)

        NavigationUI.setupWithNavController(toolbar, navController, appBarConfiguration)
    }
}

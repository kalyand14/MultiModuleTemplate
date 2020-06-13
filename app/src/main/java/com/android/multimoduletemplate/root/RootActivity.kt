package com.android.multimoduletemplate.root

import android.os.Bundle
import android.view.Menu
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.android.multimoduletemplate.R
import com.android.multimoduletemplate.core.App
import com.android.multimoduletemplate.navigation.LiveNavigationField
import com.android.multimoduletemplate.navigation.NavigationEvent
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView


class RootActivity : AppCompatActivity() {
    private val viewModel by viewModels<RootViewModel> { RootViewModelFactory(RootCoordinator, App.userManager!!) }

    //Configure the top level fragment here otherwise the up arrow will be shown to the fragment
    private val appBarConfiguration: AppBarConfiguration by lazy {
        AppBarConfiguration.Builder(
            setOf(
                R.id.login_fragment,
                R.id.onboarding_landing_fragment,
                R.id.dashboard_fragment,
                R.id.payment_fragment,
                R.id.profile_fragment
            )
        ).build()
    }

    private val navHostFragment: NavHostFragment
            by lazy { supportFragmentManager.findFragmentById(R.id.fragment_nav_host) as NavHostFragment }

    private val navController: NavController by lazy { navHostFragment.navController }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_root)
        setNavGraph()
        setToolBar()
        setBottomNavigation()
        setNavigationListener(viewModel.navigationLiveDataField)
        viewModel.subscribeObserver()
    }

    private fun setNavGraph() {
        val graph = navController.navInflater.inflate(R.navigation.nav_root)
        //graph.startDestination = RootCoordinator.startDestination().buildEvent().navId
        navController.graph = graph
    }

    private fun setToolBar() {
        val topAppBar = findViewById<MaterialToolbar>(R.id.tlb_main)
        setSupportActionBar(topAppBar)
        setupActionBarWithNavController(navController, appBarConfiguration)
        topAppBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menu_action_logout -> {
                    viewModel.logout()
                    true
                }
                else -> false
            }
        }
    }

    private fun showHideLogoutMenu(visible: Boolean) {
        val topAppBar = findViewById<MaterialToolbar>(R.id.tlb_main)
        topAppBar.menu.findItem(R.id.menu_action_logout).isVisible = visible
    }


    private fun setBottomNavigation() {
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.btm_nav_main)
        bottomNavigationView.setupWithNavController(navController)
        bottomNavigationView.visibility = View.GONE
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.login_fragment -> {
                    showHideLogoutMenu(false)
                    bottomNavigationView.visibility = View.GONE
                }
                R.id.dashboard_fragment,
                R.id.payment_fragment,
                R.id.profile_fragment -> {
                    showHideLogoutMenu(true)
                    bottomNavigationView.visibility = View.VISIBLE
                }
                else -> {
                    showHideLogoutMenu(true)
                    bottomNavigationView.visibility = View.GONE
                }
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    /**
     * Sets up the fragment to listen for navigation events from [navigationLiveDataField]
     */
    private fun setNavigationListener(navigationLiveDataField: LiveNavigationField<NavigationEvent>) {
        navigationLiveDataField.observe(this, Observer { navigate(it) })
    }

    private fun navigate(event: NavigationEvent) {
        navController.navigate(event.navId, event.navigationArguments)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_top_navigation_root, menu)
        return true
    }


}

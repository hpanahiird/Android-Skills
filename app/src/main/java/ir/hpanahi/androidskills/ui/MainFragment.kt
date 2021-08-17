package ir.hpanahi.androidskills.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import ir.hpanahi.androidskills.R
import kotlinx.android.synthetic.main.fragment_main.view.*

class MainFragment : Fragment() {

    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_main, container, false)

        val navHostFragment = childFragmentManager.findFragmentById(
            R.id.container_app_nav
        ) as NavHostFragment
        navController = navHostFragment.navController

        // Setup the bottom navigation view with navController
        val bottomNavigationView = view.bottom_nav
        bottomNavigationView.setupWithNavController(navController)

        return view
    }
}
package com.byd.ordero2.ui.activity

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.byd.ordero2.R
import com.byd.ordero2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setupNavigation()

    }
    private fun setupNavigation() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        binding.bottomNavigation.setupWithNavController(navController)
        binding.bottomNavigation.post {
            moveIndicatorTo(0, false)
        }
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.mainFragment -> {
                    binding.navIndicator.visibility = View.VISIBLE
                    moveIndicatorTo(0, true)
                    binding.bottomNavigation.visibility = View.VISIBLE
                }
                R.id.chartFragment -> {
                    binding.navIndicator.visibility = View.VISIBLE
                    binding.bottomNavigation.visibility = View.VISIBLE
                    moveIndicatorTo(1, true)
                }
                R.id.chatFragment -> {
                    binding.navIndicator.visibility = View.VISIBLE
                    binding.bottomNavigation.visibility = View.VISIBLE
                    moveIndicatorTo(2, true)
                }
                R.id.profileFragment -> {
                    binding.navIndicator.visibility = View.VISIBLE
                    binding.bottomNavigation.visibility = View.VISIBLE
                    moveIndicatorTo(3, true)
                }else -> {
                    binding.navIndicator.visibility = View.GONE
                    binding.bottomNavigation.visibility = View.GONE
              }
            }
        }

    }
    private fun moveIndicatorTo(position: Int, animate: Boolean) {
        val itemCount = 4
        val navWidth = binding.bottomNavigation.width
        val itemWidth = navWidth / itemCount
        val indicatorWidth = binding.navIndicator.width

        val targetX = itemWidth * position + (itemWidth - indicatorWidth) / 2f

        if (animate) {
            binding.navIndicator.animate()
                .x(targetX)
                .setDuration(220)
                .start()
        } else {
            binding.navIndicator.x = targetX
        }
    }
}
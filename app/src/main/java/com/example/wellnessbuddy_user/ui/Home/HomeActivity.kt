package com.example.wellnessbuddy_user.ui.Home

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.wellnessbuddy_user.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // Set window insets for edge-to-edge UI
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Setup NavController with BottomNavigationView
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment_home) as NavHostFragment
        val navController = navHostFragment.navController

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        // Attach NavController to BottomNav
        bottomNav.setupWithNavController(navController)


        val titleTextView = findViewById<TextView>(R.id.text_title)
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.nav_home -> titleTextView.text = "Home"
                R.id.nav_therapist -> titleTextView.text = "Therapist"
                R.id.nav_community -> titleTextView.text = "Community"
                R.id.nav_habbits -> titleTextView.text = "Habbits"
                else -> titleTextView.text = "Wellness Buddy"
            }
            // Optional: Handle manual item click events
            bottomNav.setOnItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.nav_home -> {
                        Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show()
                        navController.navigate(R.id.homeFragment)
                        true
                    }

                    R.id.nav_therapist -> {
                        Toast.makeText(this, "Therapist", Toast.LENGTH_SHORT).show()
                        navController.navigate(R.id.therapistFragment)
                        true
                    }

                    R.id.nav_community -> {
                        Toast.makeText(this, "Community", Toast.LENGTH_SHORT).show()
                        navController.navigate(R.id.communityFragment)
                        true
                    }

                    R.id.nav_habbits -> {
                        Toast.makeText(this, "Habits", Toast.LENGTH_SHORT).show()
                        navController.navigate(R.id.habbitsFragment)
                        true
                    }

                    else -> false
                }
            }
        }
    }
}

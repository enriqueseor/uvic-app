package cat.teknos.uvicapp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import cat.teknos.uvicapp.R
import cat.teknos.uvicapp.fragment.EventsFragment
import cat.teknos.uvicapp.fragment.BbvaFragment
import cat.teknos.uvicapp.fragment.CardFragment
import cat.teknos.uvicapp.fragment.LauncherFragment
import cat.teknos.uvicapp.fragment.TimetableFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_Uvicapp)
        setContentView(R.layout.activity_main)

        replaceFragment(EventsFragment())
        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottomNavigationView)
        bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.events -> replaceFragment(EventsFragment())
                R.id.card -> replaceFragment(CardFragment())
                R.id.timetable -> replaceFragment(TimetableFragment())
                R.id.launcher -> replaceFragment(LauncherFragment())
                R.id.bbva -> replaceFragment(BbvaFragment())
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply{
            replace(R.id.fl_wrapper, fragment)
            commit()
        }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_overflow, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_preferences -> {
                val intent = Intent(this, SettingsActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
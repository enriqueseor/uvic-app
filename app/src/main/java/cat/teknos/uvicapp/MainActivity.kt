package cat.teknos.uvicapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import cat.teknos.uvicapp.eventsfragment.EventsFragment
import cat.teknos.uvicapp.bbvafragment.BbvaFragment
import cat.teknos.uvicapp.cardfragment.CardFragment
import cat.teknos.uvicapp.launcherfragment.LauncherFragment
import cat.teknos.uvicapp.statementsfragment.StatementsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        replaceFragment(EventsFragment())
        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottomNavigationView)

        bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.events -> replaceFragment(EventsFragment())
                R.id.card -> replaceFragment(CardFragment())
                R.id.statements -> replaceFragment(StatementsFragment())
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

}
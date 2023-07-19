package cat.teknos.uvicapp.launcherfragment

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import cat.teknos.uvicapp.R

class LauncherFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {}
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view = inflater.inflate(R.layout.fragment_launcher, container, false)

        val uAcademicButton: Button = view.findViewById(R.id.uAcademic)
        uAcademicButton.setOnClickListener {
            openAppInPlayStore("com.example.comparteixcotxe")
        }

        val feseditButton: Button = view.findViewById(R.id.fesedit)
        feseditButton.setOnClickListener {
            openAppInPlayStore("com.example.comparteixcotxe")
        }

        val microsoftTeamsButton: Button = view.findViewById(R.id.microsoftTeams)
        microsoftTeamsButton.setOnClickListener {
            openAppInPlayStore("com.microsoft.teams")
        }

        val moodleButton: Button = view.findViewById(R.id.Moodle)
        moodleButton.setOnClickListener {
            openAppInPlayStore("com.moodle")
        }

        return view
    }

    private fun openAppInPlayStore(packageName: String) {
        val intent = try {
            Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=$packageName"))
        } catch (e: ActivityNotFoundException) {
            Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=$packageName"))
        }
        startActivity(intent)
    }
}
package cat.teknos.uvicapp.fragment

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.Button
import cat.teknos.uvicapp.R

class LauncherFragment : Fragment() {

    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {}
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view = inflater.inflate(R.layout.fragment_launcher, container, false)

        setupAppButtons(view)
        webView = view.findViewById(R.id.webView)

        return view
    }

    private fun setupAppButtons(view: View) {
        val uAcademicButton: Button = view.findViewById(R.id.uAcademic)
        uAcademicButton.setOnClickListener {
            openAppInPlayStore("com.sigma.mobile.target.uvic")
        }

        val feseditButton: Button = view.findViewById(R.id.fesedit)
        feseditButton.setOnClickListener {
            openAppInPlayStore("cat.easy.fesedit")
        }

        val microsoftTeamsButton: Button = view.findViewById(R.id.microsoftTeams)
        microsoftTeamsButton.setOnClickListener {
            openAppInPlayStore("com.microsoft.teams")
        }

        val moodleButton: Button = view.findViewById(R.id.moodleApp)
        moodleButton.setOnClickListener {
            openAppInPlayStore("com.moodle.moodlemobile")
        }
    }

    private fun openAppInPlayStore(packageName: String) {
        val intent = try {
            Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=$packageName"))
        } catch (e: ActivityNotFoundException) {
            Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=$packageName"))
        }
        startActivity(intent)
    }

    private fun setupWebButtons(view: View) {
        val uVals: Button = view.findViewById(R.id.uVals)
        uVals.setOnClickListener {
            openWebsite("https://uvalsuvic.cat/")
        }

        val desTerritori: Button = view.findViewById(R.id.desTerritori)
        desTerritori.setOnClickListener {
            openWebsite("https://mon.uvic.cat/uviclife/esports/descobreix-el-territori/")
        }

        val uVicShop: Button = view.findViewById(R.id.uVicShop)
        uVicShop.setOnClickListener {
            openWebsite("https://uvicshop.cat/es/")
        }

        val campusInternacional: Button = view.findViewById(R.id.campusInternacional)
        campusInternacional.setOnClickListener {
            openWebsite("https://www.uvic.cat/es/internacional/uvic-ucc-campus-internacional")
        }

        val moodleWeb: Button = view.findViewById(R.id.moodleWeb)
        moodleWeb.setOnClickListener {
            openWebsite("https://www.uvic.cat/biblioteca/serveis/connectat-a-laprenentatge-virtual/iniciacio-a-laula-moodle")
        }

        val ubiqua: Button = view.findViewById(R.id.ubiqua)
        ubiqua.setOnClickListener {
            openWebsite("https://ubiqua.uvic.cat/")
        }

        val uRespon: Button = view.findViewById(R.id.uRespon)
        uRespon.setOnClickListener {
            openWebsite("https://mon.uvic.cat/ajutcampus/urespon-gestor-dincidencies/")
        }

        val biblioteca: Button = view.findViewById(R.id.biblioteca)
        biblioteca.setOnClickListener {
            openWebsite("https://ucercatot.uvic-ucc.cat/discovery/login?vid=34CSUC_UVIC:VU1&lang=es")
        }

        val portalOcupacio: Button = view.findViewById(R.id.portalOcupacio)
        portalOcupacio.setOnClickListener {
            openWebsite("https://www.uvic.cat/portal-docupacio")
        }

        val u360: Button = view.findViewById(R.id.u360)
        u360.setOnClickListener {
            openWebsite("https://u360.uvic.cat/espais")
        }

        val pasaporteCultural: Button = view.findViewById(R.id.pasaporteCultural)
        pasaporteCultural.setOnClickListener {
            openWebsite("https://www.uvic.cat/es/uhub/pasaporte-cultural")
        }
    }

    private fun openWebsite(url: String) {
        Log.d("WebViewDebug", "Opening website: $url")
        webView.visibility = View.VISIBLE
        webView.loadUrl(url)
    }
}
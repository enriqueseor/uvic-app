package cat.teknos.uvicapp.bbvafragment

import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.TypedValue
import android.view.ContextThemeWrapper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import cat.teknos.uvicapp.R
import cat.teknos.uvicapp.WebActivity

class BbvaFragment : Fragment() {

    private var statusBarColor: Int = 0
    private var colorChanged: Boolean = false

    override fun onResume() {
        super.onResume()

        if (!colorChanged) {
            val themeResId = R.style.Theme_Uvicapp
            val contextThemeWrapper = ContextThemeWrapper(requireActivity(), themeResId)
            val theme = contextThemeWrapper.theme
            val typedValue = TypedValue()

            theme.resolveAttribute(com.google.android.material.R.attr.colorSecondary, typedValue, true)
            val secondaryColor = typedValue.data
            val actionBar = (requireActivity() as AppCompatActivity).supportActionBar
            actionBar?.setBackgroundDrawable(ColorDrawable(secondaryColor))

            theme.resolveAttribute(com.google.android.material.R.attr.colorSecondaryVariant, typedValue, true)
            val secondaryVariantColor = typedValue.data
            statusBarColor = requireActivity().window.statusBarColor
            requireActivity().window.statusBarColor = secondaryVariantColor

            colorChanged = true
        }
    }

    override fun onPause() {
        super.onPause()

        if (colorChanged) {
            val themeResId = R.style.Theme_Uvicapp
            val contextThemeWrapper = ContextThemeWrapper(requireActivity(), themeResId)
            val theme = contextThemeWrapper.theme
            val typedValue = TypedValue()

            theme.resolveAttribute(com.google.android.material.R.attr.colorPrimary, typedValue, true)
            val primaryColor = typedValue.data

            val actionBar = (requireActivity() as AppCompatActivity).supportActionBar
            actionBar?.setBackgroundDrawable(ColorDrawable(primaryColor))
            requireActivity().window.statusBarColor = statusBarColor

            colorChanged = false
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val themedInflater = inflater.cloneInContext(requireActivity())
        val view = themedInflater.inflate(R.layout.fragment_bbva, container, false)

        // Get references to the image views
        val imageTopLeft = view.findViewById<ImageView>(R.id.imageTopLeft)
        val imageTopRight = view.findViewById<ImageView>(R.id.imageTopRight)
        val imageBottomLeft = view.findViewById<ImageView>(R.id.imageBottomLeft)
        val imageBottomRight = view.findViewById<ImageView>(R.id.imageBottomRight)

        // Set click listeners for the image views
        imageTopLeft.setOnClickListener {
            openWebActivity("https://www.bbva.es/personas/jovenes.html")
        }

        imageTopRight.setOnClickListener {
            openWebActivity("https://www.bbva.es/personas/apps/bbva-espana.html")
        }

        imageBottomLeft.setOnClickListener {
            openWebActivity("https://aprendemosjuntos.bbva.com/")
        }

        imageBottomRight.setOnClickListener {
            openWebActivity("https://www.bbva.es/finanzas-vistazo/ef.html")
        }

        return view
    }

    private fun openWebActivity(url: String) {
        val intent = Intent(requireContext(), WebActivity::class.java)
        intent.putExtra(WebActivity.EXTRA_URL, url)
        startActivity(intent)
    }
}
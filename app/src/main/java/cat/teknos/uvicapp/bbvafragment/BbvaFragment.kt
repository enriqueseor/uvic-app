package cat.teknos.uvicapp.bbvafragment

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.TypedValue
import android.view.ContextThemeWrapper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import cat.teknos.uvicapp.R

class BbvaFragment : Fragment() {

    private var actionBarColor: Int = 0
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
            val actionBar = (requireActivity() as AppCompatActivity).supportActionBar
            actionBar?.setBackgroundDrawable(ColorDrawable(com.google.android.material.R.attr.colorPrimary))
            requireActivity().window.statusBarColor = statusBarColor
            colorChanged = false
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val themedInflater = inflater.cloneInContext(requireActivity())
        return themedInflater.inflate(R.layout.fragment_bbva, container, false)
    }
}
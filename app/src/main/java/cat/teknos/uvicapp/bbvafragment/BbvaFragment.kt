package cat.teknos.uvicapp.bbvafragment

import android.os.Bundle
import android.util.TypedValue
import android.view.ContextThemeWrapper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import cat.teknos.uvicapp.R

class BbvaFragment : Fragment() {

    private var statusBarColor: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {}
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val themeResId = R.style.Theme_Uvicapp
        val contextThemeWrapper = ContextThemeWrapper(requireActivity(), themeResId)
        val theme = contextThemeWrapper.theme
        val typedValue = TypedValue()

        theme.resolveAttribute(com.google.android.material.R.attr.colorSecondaryVariant, typedValue, true)
        val secondaryVariantColor = typedValue.data

        // Set the status bar color
        statusBarColor = requireActivity().window.statusBarColor
        requireActivity().window.statusBarColor = secondaryVariantColor

        // Apply the updated theme
        val themedInflater = inflater.cloneInContext(contextThemeWrapper)
        return themedInflater.inflate(R.layout.fragment_bbva, container, false)
    }

    override fun onDestroyView() {
        super.onDestroyView()

        // Reset the status bar color
        requireActivity().window.statusBarColor = statusBarColor
    }
}
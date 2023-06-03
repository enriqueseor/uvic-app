package cat.teknos.uvicapp.bbvafragment

import android.os.Bundle
import android.util.TypedValue
import android.view.ContextThemeWrapper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import cat.teknos.uvicapp.R

class BbvaFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {}
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val primaryColor = ContextCompat.getColor(requireContext(), R.color.teal_200)
        val secondaryColor = ContextCompat.getColor(requireContext(), R.color.teal_200)

        val themeResId = R.style.Theme_Uvicapp
        val contextThemeWrapper = ContextThemeWrapper(requireActivity(), themeResId)
        val theme = contextThemeWrapper.theme
        val typedValue = TypedValue()

        theme.resolveAttribute(com.google.android.material.R.attr.colorPrimary, typedValue, true)
        typedValue.data = primaryColor
        theme.resolveAttribute(com.google.android.material.R.attr.colorPrimaryVariant, typedValue, true)
        typedValue.data = secondaryColor

        // Apply the updated theme
        val themedInflater = inflater.cloneInContext(contextThemeWrapper)
        return themedInflater.inflate(R.layout.fragment_bbva, container, false)
    }
}
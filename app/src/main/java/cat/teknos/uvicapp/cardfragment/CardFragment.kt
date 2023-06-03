package cat.teknos.uvicapp.cardfragment

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import cat.teknos.uvicapp.R

class CardFragment : Fragment() {

    private var isImageVisible = false
    private lateinit var handler: Handler
    private lateinit var toggleVisibilityRunnable: Runnable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {}
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view = inflater.inflate(R.layout.fragment_card, container, false)
        val iconSportsGreen: ImageView? = view.findViewById(R.id.icon_sports_green)
        handler = Handler(Looper.getMainLooper())
        toggleVisibilityRunnable = Runnable {
            iconSportsGreen?.visibility = if (isImageVisible) View.VISIBLE else View.INVISIBLE
            isImageVisible = !isImageVisible
            scheduleToggleVisibility()
        }
        scheduleToggleVisibility()
        return view
    }

    private fun scheduleToggleVisibility() {
        handler.postDelayed(toggleVisibilityRunnable, 500)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        handler.removeCallbacks(toggleVisibilityRunnable)
    }
}
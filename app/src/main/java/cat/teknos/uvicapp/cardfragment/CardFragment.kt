package cat.teknos.uvicapp.cardfragment

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import cat.teknos.uvicapp.R
import java.text.SimpleDateFormat
import java.util.*

class CardFragment : Fragment() {

    private var isImageVisible = false
    private lateinit var handler: Handler
    private lateinit var tvTimer: TextView
    private lateinit var toggleVisibilityRunnable: Runnable

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
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
        tvTimer = view.findViewById(R.id.tvTimer)
        handler = Handler(Looper.getMainLooper())
        handler.post(updateClockRunnable)
        return view
    }

    private val updateClockRunnable = object : Runnable {
        override fun run() {
            val currentDate = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault()).format(Date())
            val currentTime = SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(Date())
            val dateTime = "$currentDate - $currentTime"
            tvTimer.text = dateTime
            handler.postDelayed(this, 1000) // Update every second
        }
    }

    private fun scheduleToggleVisibility() {
        handler.postDelayed(toggleVisibilityRunnable, 500)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        handler.removeCallbacks(toggleVisibilityRunnable)
        handler.removeCallbacks(updateClockRunnable)
    }
}

package cat.teknos.uvicapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.LinearInterpolator
import android.widget.ImageView

class CardFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {}
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_card, container, false)
        val myImage = rootView.findViewById<ImageView>(R.id.icon_sports_green)

        val animation = AlphaAnimation(0.0f, 1.0f) // from fully transparent to fully opaque
        animation.duration = 500 // duration in milliseconds
        animation.interpolator = LinearInterpolator() // animation style
        animation.repeatCount = Animation.INFINITE // repeat indefinitely
        animation.repeatMode = Animation.REVERSE // reverse the animation at the end

        myImage.startAnimation(animation)

        return rootView
    }
}
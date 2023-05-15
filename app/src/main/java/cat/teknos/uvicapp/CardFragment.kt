package cat.teknos.uvicapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.widget.ImageView

class CardFragment : Fragment() {

    private var isImageVisible = false
    private lateinit var fadeInAnimation: Animation
    private lateinit var fadeOutAnimation: Animation

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
        fadeInAnimation = AlphaAnimation(0f, 1f).apply {
            duration = 500
            setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(animation: Animation?) {}
                override fun onAnimationEnd(animation: Animation?) {
                    iconSportsGreen?.visibility = if (isImageVisible) View.VISIBLE else View.INVISIBLE
                    isImageVisible = !isImageVisible
                    iconSportsGreen?.startAnimation(fadeOutAnimation)
                }
                override fun onAnimationRepeat(animation: Animation?) {}
            })
        }
        fadeOutAnimation = AlphaAnimation(1f, 0f).apply {
            duration = 500
            setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(animation: Animation?) {}
                override fun onAnimationEnd(animation: Animation?) {
                    iconSportsGreen?.startAnimation(fadeInAnimation)
                }
                override fun onAnimationRepeat(animation: Animation?) {}
            })
        }
        iconSportsGreen?.startAnimation(fadeInAnimation)

        return view
    }
}
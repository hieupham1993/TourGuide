package hieupt.tourguidedemo

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.view.animation.BounceInterpolator
import android.view.animation.TranslateAnimation
import kotlinx.android.synthetic.main.activity_customization.*
import hieupt.tourguide.TourGuide


class ToolTipCustomizationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customization)

        val tourGuide = TourGuide.create(this).playOn(button) {
            toolTip {
                title { "Next Button" }
                description { "Click on Next button to proceed..." }
                textColor { Color.parseColor("#bdc3c7") }
                backgroundColor { Color.parseColor("#e74c3c") }
                shadow { true }
                gravity { Gravity.TOP or Gravity.START }
                enterAnimation {
                    TranslateAnimation(0f, 0f, 200f, 0f).apply {
                        duration = 1000
                        fillAfter = true
                        interpolator = BounceInterpolator()
                    }
                }
            }
        }.show()

        button.setOnClickListener { tourGuide.cleanUp() }
    }
}

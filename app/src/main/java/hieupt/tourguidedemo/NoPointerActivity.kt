package hieupt.tourguidedemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_basic.*
import hieupt.tourguide.TourGuide


class NoPointerActivity : AppCompatActivity() {
    lateinit var tourGuide: TourGuide
    override fun onCreate(savedInstanceState: Bundle?) {
        /* Get parameters from main activity */
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic)

        button1.text = "Purchase"

        tourGuide = TourGuide.create(this) {
            overlay {
                onClickListener { View.OnClickListener { tourGuide.cleanUp() } }
            }
        }.playOn(button1) {
            toolTip {
                title { "Expensive Item" }
                description { "Click 'purchase' only when you are ready\nClick on the anywhere to dismiss" }
            }
            canClickThroughHole { false }
        }.show()

        button2.setOnClickListener {
            tourGuide.playOn(button1) {
                toolTip {
                    title { "Expensive Item" }
                    description { "Click 'purchase' only when you are ready\nClick on the anywhere to dismiss" }
                }
                canClickThroughHole { false }
            }.show()
        }
    }
}

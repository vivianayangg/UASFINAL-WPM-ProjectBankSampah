package com.azhar.banksampah.view.onboard

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.azhar.banksampah.R
import com.azhar.banksampah.view.main.MainActivity

class WelcomeActivity : AppCompatActivity() {
    // on below line we are creating a
    // variable for our view pager
    lateinit var viewPager: ViewPager

    // on below line we are creating a variable
    // for our slider adapter and slider list
    lateinit var sliderAdapter: SliderAdapter
    lateinit var sliderList: ArrayList<SliderData>

    // on below line we are creating a variable for our
    // skip button, slider indicator text view for 3 dots
    lateinit var skipBtn: Button
    lateinit var indicatorSlideOneTV: TextView
    lateinit var indicatorSlideTwoTV: TextView
    lateinit var indicatorSlideThreeTV: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        // on below line we are initializing all
        // our variables with their ids.
        viewPager = findViewById(R.id.idViewPager)
        skipBtn = findViewById(R.id.idBtnSkip)
        indicatorSlideOneTV = findViewById(R.id.idTVSlideOne)
        indicatorSlideTwoTV = findViewById(R.id.idTVSlideTwo)
        indicatorSlideThreeTV = findViewById(R.id.idTVSlideThree)

        // on below line we are adding click listener for our skip button
        skipBtn.setOnClickListener {
            // on below line we are opening a new activity
            val i = Intent(this@WelcomeActivity, LoginActivity::class.java)
            startActivity(i)
        }

        // on below line we are initializing our slider list.
        sliderList = ArrayList()

        // on below line we are adding data to our list
        sliderList.add(
            SliderData(
                "Menjaga Lingkungan Anda",
                "Pentingnya menjaga lingkungan wajib harus kita tanamkan sejak dini. Menjaga lingkungan agar tetap bersih dan nyaman.",
                R.drawable.slide_1
            )
        )

        sliderList.add(
            SliderData(
                "Praktis",
                "Memudahkan pengguna dalam menggunakan aplikasi Bank Sampah ini.",
                R.drawable.slide_2
            )
        )

        sliderList.add(
            SliderData(
                "Cepat Dan Terpercaya",
                "Menjadi pilihan untuk membantu dalam menjaga lingkungan disekitar anda.",
                R.drawable.slide_3
            )
        )

        // on below line we are adding slider list
        // to our adapter class.
        sliderAdapter = SliderAdapter(this, sliderList)

        // on below line we are setting adapter
        // for our view pager on below line.
        viewPager.adapter = sliderAdapter

        // on below line we are adding page change
        // listener for our view pager.
        viewPager.addOnPageChangeListener(viewListener)

    }

    // creating a method for view pager for on page change listener.
    var viewListener: ViewPager.OnPageChangeListener = object : ViewPager.OnPageChangeListener {
        override fun onPageScrolled(
            position: Int,
            positionOffset: Float,
            positionOffsetPixels: Int
        ) {
        }

        override fun onPageSelected(position: Int) {
            // we are calling our dots method to
            // change the position of selected dots.

            // on below line we are checking position and updating text view text color.
            if (position == 0) {
                indicatorSlideTwoTV.setTextColor(resources.getColor(R.color.grey))
                indicatorSlideThreeTV.setTextColor(resources.getColor(R.color.grey))
                indicatorSlideOneTV.setTextColor(resources.getColor(R.color.white))

            } else if (position == 1) {
                indicatorSlideTwoTV.setTextColor(resources.getColor(R.color.white))
                indicatorSlideThreeTV.setTextColor(resources.getColor(R.color.grey))
                indicatorSlideOneTV.setTextColor(resources.getColor(R.color.grey))
            } else {
                indicatorSlideTwoTV.setTextColor(resources.getColor(R.color.grey))
                indicatorSlideThreeTV.setTextColor(resources.getColor(R.color.white))
                indicatorSlideOneTV.setTextColor(resources.getColor(R.color.grey))
            }
        }

        // below method is use to check scroll state.
        override fun onPageScrollStateChanged(state: Int) {}
    }

}
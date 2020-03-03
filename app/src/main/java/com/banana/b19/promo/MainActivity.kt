package com.banana.b19.promo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.absoluteValue

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewPager.adapter = Adapter()
        viewPager.setPageTransformer(true,Zoom())
        Tabs.setupWithViewPager(viewPager)
        Indicator.setViewPager(viewPager)
    }

    class Zoom : ViewPager.PageTransformer{
        override fun transformPage(page: View, position: Float) {
            var scale = 1 - position.absoluteValue
            var rotation_x = page.rotation
            if (scale < 0.8) scale = .8f
            page.scaleX = scale
            page.scaleY = scale
            page.alpha = scale
            page.rotation = position * 360
        }
    }


    inner class Adapter :
        FragmentPagerAdapter(supportFragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){


        override fun getItem(position: Int): Fragment {
           return when(position) {
                0 -> PageFragment()
                1 -> PageFragment()
               else -> PageFragment()
            }
        }

        override fun getPageTitle(position:Int):CharSequence?{
            return when(position){
                else -> position.toString()

                }


        }

        override fun getCount(): Int = 10

    }

}

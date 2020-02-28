package com.banana.b19.promo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewPager.adapter = Adapter()

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

        override fun getCount(): Int = 10

    }

}

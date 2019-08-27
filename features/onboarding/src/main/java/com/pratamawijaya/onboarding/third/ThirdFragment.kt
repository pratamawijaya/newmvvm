package com.pratamawijaya.onboarding.third


import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pratamawijaya.navigation.Navigations

import com.pratamawijaya.onboarding.R
import kotlinx.android.synthetic.main.fragment_third.*

/**
 * A simple [Fragment] subclass.
 */
class ThirdFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val act = activity as Activity

        btnGoToHomepage.setOnClickListener {
            startActivity(Navigations.openHomepage(act))
        }
    }
}
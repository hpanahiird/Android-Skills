package ir.hpanahi.androidskills.ui.onboarding.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import ir.hpanahi.androidskills.R
import kotlinx.android.synthetic.main.fragment_skills_intro.view.*

class SkillsIntroFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_skills_intro, container, false)

        val viewPager2 =
            requireActivity().findViewById<ViewPager2>(R.id.viewpager_on_boarding_fragments)

        view.btn_skills_intro_finish.setOnClickListener {
//            viewPager2.currentItem = 2
        }

        view.btn_skills_intro_back.setOnClickListener {
            viewPager2.currentItem = 1
        }

        return view
    }

}
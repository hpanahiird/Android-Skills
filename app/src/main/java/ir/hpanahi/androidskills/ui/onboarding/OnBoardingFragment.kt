package ir.hpanahi.androidskills.ui.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import ir.hpanahi.androidskills.R
import ir.hpanahi.androidskills.ui.onboarding.screens.NameIntroFragment
import ir.hpanahi.androidskills.ui.onboarding.screens.ResumeIntroFragment

class OnBoardingFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_on_boarding, container, false)

        val fragments = arrayListOf<Fragment>(
            NameIntroFragment(),
            ResumeIntroFragment()
        )

        val adapter = OnBoardingViewPagerAdapter(fragments, requireActivity().supportFragmentManager, lifecycle)

        view.findViewById<ViewPager2>(R.id.viewpager_on_boarding_fragments).adapter = adapter

        return view
    }
}
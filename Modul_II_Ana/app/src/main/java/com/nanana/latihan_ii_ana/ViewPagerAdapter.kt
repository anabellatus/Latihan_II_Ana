package com.nanana.latihan_ii_ana

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity) {

    private val JUMLAH_MENU = 3
    override fun getItemCount(): Int {
        return JUMLAH_MENU
    }

    override fun createFragment(position: Int): Fragment {
        when(position){
            0 -> { return GithubFragment() }
            1 -> { return MyFriendsFragment() }
            2 -> { return ProfilFragment() }
            else -> {
                return GithubFragment()
            }
        }
    }
}
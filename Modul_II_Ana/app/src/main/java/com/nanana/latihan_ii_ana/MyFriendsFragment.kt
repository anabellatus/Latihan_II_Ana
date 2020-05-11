package com.nanana.latihan_ii_ana

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_my_friends.*

class MyFriendsFragment : Fragment() {

    lateinit var listTeman: ArrayList<MyFriends>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_my_friends, container, false)
    }

    override fun onViewCreated(view: View, @Nullable savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun tampilTeman(){
        rv_listMyFriends.layoutManager = LinearLayoutManager(activity)
        rv_listMyFriends.adapter = MyFriendAdapter(activity!!, listTeman)
    }

    private fun initView(){
        simulasiDataTeman()
        tampilTeman()
    }

    private fun simulasiDataTeman(){
        listTeman = ArrayList()
        listTeman.add(MyFriends("Ana", "Perempuan", "anabellatus@gmail.com", "0895342613748", "Jalan di rumah aja"))
        listTeman.add(MyFriends("Bella", "Perempuan", "bellatusana@gmail.com", "0895342613748", "Jalan sendiri"))
    }

    override fun onDestroy() {
        super.onDestroy()
        this.clearFindViewByIdCache()
    }
}

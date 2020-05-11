package com.nanana.latihan_ii_ana

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.recyclerview.widget.LinearLayoutManager
import com.nanana.latihan_ii_ana.data.GithubService
import com.nanana.latihan_ii_ana.data.apiRequest
import com.nanana.latihan_ii_ana.data.httpClient
import com.nanana.latihan_ii_ana.util.dismissLoading
import com.nanana.latihan_ii_ana.util.showLoading
import com.nanana.latihan_ii_ana.util.tampilToast
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_github.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GithubFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_github, container, false)
    }

    override fun onViewCreated(view: View, @Nullable savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        callApiGetGithubUSer()
    }

    private fun callApiGetGithubUSer() {
        showLoading(context!!, swipeRefreshLayout)

        val httpClient = httpClient()
        val apiRequest = apiRequest<GithubService>(httpClient)

        val call = apiRequest.getUsers()
        call.enqueue(object : Callback<List<GithubUserItem>> {

            override fun onFailure(call: Call<List<GithubUserItem>>, t: Throwable) {
                dismissLoading(swipeRefreshLayout)
            }

            override fun onResponse(
                call: Call<List<GithubUserItem>>,
                response: Response<List<GithubUserItem>>
            ) {
                dismissLoading(swipeRefreshLayout)

                when {
                    response.isSuccessful ->
                        when {
                            response.body()!!.size != 0 ->
                                tampilGithubUser(response.body()!!)
                            else -> {
                                tampilToast(context!!, "Berhasil")
                            }
                        }
                    else -> {
                        tampilToast(context!!, "Gagal")
                    }
                }
            }
        })
    }

    private fun tampilGithubUser(githubUser: List<GithubUserItem>){
        listGithubUser.layoutManager = LinearLayoutManager(context)
        listGithubUser.adapter = GithubUserAdapter(context!!, githubUser){
            val githubUser = it
            tampilToast(context!!, githubUser.login)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        this.clearFindViewByIdCache()
    }

}

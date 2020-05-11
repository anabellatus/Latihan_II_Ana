package com.nanana.latihan_ii_ana.data

import com.nanana.latihan_ii_ana.GithubUserItem
import retrofit2.Call
import retrofit2.http.GET

interface GithubService {
    @GET ("users")
    fun getUsers(): Call<List<GithubUserItem>>
}
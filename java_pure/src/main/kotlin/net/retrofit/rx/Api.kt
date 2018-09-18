package net.retrofit.rx

import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.QueryMap
import rx.Observable

interface Api {

    @GET("hi/login")
    fun login(): Observable<String>

    @POST("hi/login")
    fun login(@QueryMap map: Map<String, String>): Observable<String>

    @GET(".")
    fun getGithub(): Observable<String>
}
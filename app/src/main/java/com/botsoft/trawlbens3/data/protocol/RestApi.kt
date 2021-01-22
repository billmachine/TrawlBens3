package com.botsoft.trawlbens3.data.protocol

import com.botsoft.trawlbens3.data.entity.DetailGame
import com.botsoft.trawlbens3.data.entity.Game
import com.botsoft.trawlbens3.data.entity.GameResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface RestApi {

    @GET("games")
    suspend fun getGames(): GameResponse

    @GET("games/{id}")
    fun getDetailGame(@Path("id")id:Int): DetailGame?
}
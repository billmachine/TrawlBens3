package com.botsoft.trawlbens3.data.repository

import androidx.lifecycle.LiveData
import com.botsoft.trawlbens3.data.protocol.RestApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GameRepository @Inject constructor(
//    val db: AppDatabase,
    val post: RestApi
)  {
    init { }

    suspend fun fetchRemoteGames() = post.getGames().results

    fun getDetailGameById(id:Int) = post.getDetailGame(id)

}
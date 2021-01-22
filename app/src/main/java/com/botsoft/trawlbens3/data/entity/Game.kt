package com.botsoft.trawlbens3.data.entity

data class GameResponse(
    val results: List<Game>
)

data class Game(
    val background_image: String?,
    val id: Int?,
    val name: String?,
    val released: String?
)


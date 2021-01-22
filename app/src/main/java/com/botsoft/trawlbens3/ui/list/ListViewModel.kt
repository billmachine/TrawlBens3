package com.botsoft.trawlbens3.ui.list

import androidx.lifecycle.*
import com.botsoft.trawlbens3.data.entity.Game
import com.botsoft.trawlbens3.data.repository.GameRepository
import kotlinx.coroutines.async
import javax.inject.Inject

class ListViewModel @Inject constructor(
    val gameRepository:GameRepository
):ViewModel() {

    private val _gameList = MutableLiveData<List<Game>>()
    val gameList: LiveData<List<Game>>
        get() = _gameList

    init {
        getGames()
    }

    fun getGames() {
        viewModelScope.async  {
            try {
                val games = gameRepository.fetchRemoteGames()
                _gameList.postValue(games)
                println("error happensx never")
            } catch (throwable : Throwable){
                println("error happensx ${throwable.message}")
            }
        }
    }
}
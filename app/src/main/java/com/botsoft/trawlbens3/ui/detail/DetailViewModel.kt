package com.botsoft.trawlbens3.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.botsoft.trawlbens3.data.entity.DetailGame
import com.botsoft.trawlbens3.data.entity.Game
import com.botsoft.trawlbens3.data.repository.GameRepository
import io.reactivex.functions.Consumer
import kotlinx.coroutines.async
import javax.inject.Inject

class DetailViewModel @Inject constructor(
    val gameRepository: GameRepository
):ViewModel() {

    fun getGamesById(id:Int):LiveData<DetailGame> {
        var response = MutableLiveData<DetailGame>()
         gameRepository.getDetailGameById(id).subscribe(Consumer {
             response.postValue(it)
         })
        return response
    }

}
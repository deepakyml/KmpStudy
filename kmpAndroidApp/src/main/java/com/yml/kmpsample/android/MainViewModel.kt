package com.yml.kmpsample.android

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yml.kmpsample.NewsUseCase
import com.yml.kmpsample.models.NewsArticle
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    sealed class State {
        object Loading: State()
        data class Data(val data: List<NewsArticle>): State()
    }

    private var _state = MutableStateFlow<State>(State.Loading)
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            val data = NewsUseCase().fetchTopNews()
                data?.let {
                    _state.value = State.Data(it)
                }
//            while (isActive) {
//                val data = NewsUseCase().fetchTopNews()
//                data.articles?.let {
//                    _state.value = State.Data(it)
//                }
//                delay(60 * 1000L)
//            }
        }
    }
}
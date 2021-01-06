package com.aungpyaesone.mvi_architecutre_android_beginners.ui.main.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aungpyaesone.mvi_architecutre_android_beginners.data.repository.MainRepository
import com.aungpyaesone.mvi_architecutre_android_beginners.ui.main.intent.MainIntent
import com.aungpyaesone.mvi_architecutre_android_beginners.ui.main.viewstate.MainState
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch
import java.lang.Exception

class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {
    val userIntent = Channel<MainIntent>(Channel.UNLIMITED)
    private val _state = MutableStateFlow<MainState>(MainState.Idle)

    val state: StateFlow<MainState>
        get() = _state

    init {
        handleIntent()
    }

    private fun handleIntent() {
        viewModelScope.launch {
            userIntent.consumeAsFlow().collect {
                when (it) {
                    is MainIntent.FetchUser -> fetchUser()
                    is MainIntent.SwipeRefreshIntent -> fetchUser()
                }
            }
        }
    }

    private fun fetchUser() {
        viewModelScope.launch {
            _state.value = MainState.Loading
            _state.value = try {
                MainState.Users(mainRepository.getUsers())
            } catch (e: Exception) {
                MainState.Errors(e.localizedMessage)
            }

        }
    }
}
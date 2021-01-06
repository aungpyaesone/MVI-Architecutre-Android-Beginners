package com.aungpyaesone.mvi_architecutre_android_beginners.ui.main.viewstate

import com.aungpyaesone.mvi_architecutre_android_beginners.data.model.User

sealed class MainState {
    object Idle: MainState()
    object Loading : MainState()
    data class Users(val user:List<User>) : MainState()
    data class Errors(val error: String?) : MainState()
}
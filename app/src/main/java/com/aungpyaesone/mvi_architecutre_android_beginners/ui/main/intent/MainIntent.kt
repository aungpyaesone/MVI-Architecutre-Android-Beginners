package com.aungpyaesone.mvi_architecutre_android_beginners.ui.main.intent

sealed class MainIntent {
    object FetchUser : MainIntent()
    object SwipeRefreshIntent : MainIntent()
}
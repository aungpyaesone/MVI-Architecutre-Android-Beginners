package com.aungpyaesone.mvi_architecutre_android_beginners.data.api

import com.aungpyaesone.mvi_architecutre_android_beginners.data.model.User

interface ApiHelper {
    suspend fun getUsers() : List<User>
}
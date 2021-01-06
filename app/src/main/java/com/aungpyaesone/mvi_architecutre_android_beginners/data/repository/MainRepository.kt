package com.aungpyaesone.mvi_architecutre_android_beginners.data.repository

import com.aungpyaesone.mvi_architecutre_android_beginners.data.api.ApiHelper

class MainRepository(private val apiHelper: ApiHelper) {
    suspend fun getUsers() =  apiHelper.getUsers()
}
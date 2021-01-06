package com.aungpyaesone.mvi_architecutre_android_beginners.data.api.impls

import com.aungpyaesone.mvi_architecutre_android_beginners.data.api.ApiHelper
import com.aungpyaesone.mvi_architecutre_android_beginners.data.api.ApiService
import com.aungpyaesone.mvi_architecutre_android_beginners.data.model.User

class ApiHelperImpl(private val apiService: ApiService): ApiHelper {

    override suspend fun getUsers(): List<User> {
        return apiService.getUsers()
    }
}




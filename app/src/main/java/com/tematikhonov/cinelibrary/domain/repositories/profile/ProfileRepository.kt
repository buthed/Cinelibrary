package com.tematikhonov.cinelibrary.domain.repositories.profile

import android.content.Context
import com.tematikhonov.cinelibrary.domain.models.entites.LanguagesList


interface ProfileRepository  {

    val context: Context

    fun clearCache(context: Context)

    fun getNotificationBoolean(): Boolean

    fun setNotificationBoolean(boolean: Boolean)

    suspend fun getLanguages(): LanguagesList

}
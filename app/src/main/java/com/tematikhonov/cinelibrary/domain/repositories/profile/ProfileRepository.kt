package com.tematikhonov.cinelibrary.domain.repositories.profile

import android.content.Context


interface ProfileRepository  {

    val context: Context

    fun clearCache(context: Context)

    fun getNotificationBoolean(): Boolean

    fun setNotificationBoolean(boolean: Boolean)

}
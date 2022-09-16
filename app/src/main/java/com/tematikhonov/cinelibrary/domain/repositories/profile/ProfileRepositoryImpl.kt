package com.tematikhonov.cinelibrary.domain.repositories.profile

import android.content.Context
import androidx.preference.PreferenceManager
import com.tematikhonov.cinelibrary.domain.models.Constants
import com.tematikhonov.cinelibrary.domain.models.Constants.PREF_NOTIFICATION

class ProfileRepositoryImpl(override val context: Context): ProfileRepository {

    override fun clearCache(context: Context) {
        context.cacheDir.deleteRecursively()
    }

    override fun getNotificationBoolean(): Boolean {
        val preferences = PreferenceManager.getDefaultSharedPreferences(context)
        return preferences.getBoolean(PREF_NOTIFICATION, false)
    }

    override fun setNotificationBoolean(boolean: Boolean) {
        val preferences = PreferenceManager.getDefaultSharedPreferences(context)
        preferences.edit()
            .putBoolean(Constants.PREF_NOTIFICATION,boolean)
            .apply()
    }
}
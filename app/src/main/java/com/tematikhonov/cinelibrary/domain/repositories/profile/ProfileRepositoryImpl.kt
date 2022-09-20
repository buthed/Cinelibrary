package com.tematikhonov.cinelibrary.domain.repositories.profile

import android.content.Context
import androidx.preference.PreferenceManager
import com.tematikhonov.cinelibrary.BuildConfig.API_KEY
import com.tematikhonov.cinelibrary.data.network.ApiTMDBService
import com.tematikhonov.cinelibrary.domain.models.ApiConstants

import com.tematikhonov.cinelibrary.domain.models.Constants
import com.tematikhonov.cinelibrary.domain.models.Constants.PREF_NOTIFICATION
import com.tematikhonov.cinelibrary.domain.models.entites.LanguagesList
import javax.inject.Inject

class ProfileRepositoryImpl @Inject constructor(override val context: Context, val apiService: ApiTMDBService): ProfileRepository {


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

    override suspend fun getLanguages() = apiService.getLanguages(API_KEY)
}
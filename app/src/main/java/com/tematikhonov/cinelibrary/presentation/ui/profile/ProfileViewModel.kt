package com.tematikhonov.cinelibrary.presentation.ui.profile

import androidx.lifecycle.ViewModel
import com.tematikhonov.cinelibrary.domain.repositories.profile.ProfileRepository
import com.tematikhonov.cinelibrary.domain.repositories.profile.ProfileRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(private val profileRepositoryImpl: ProfileRepositoryImpl): ViewModel() {

    fun clearCache() =  profileRepositoryImpl.clearCache(profileRepositoryImpl.context)

    fun setNotificationPref(boolean: Boolean) = profileRepositoryImpl.setNotificationBoolean(boolean)

    fun getNotificationBoolean() = profileRepositoryImpl.getNotificationBoolean()

}
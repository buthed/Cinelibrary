package com.tematikhonov.cinelibrary.presentation.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tematikhonov.cinelibrary.domain.models.entites.GenresResult
import com.tematikhonov.cinelibrary.domain.models.entites.LanguagesList
import com.tematikhonov.cinelibrary.domain.repositories.profile.ProfileRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(private val profileRepositoryImpl: ProfileRepositoryImpl): ViewModel() {

    fun clearCache() =  profileRepositoryImpl.clearCache(profileRepositoryImpl.context)

    fun setNotificationPref(boolean: Boolean) = profileRepositoryImpl.setNotificationBoolean(boolean)

    fun getNotificationBoolean() = profileRepositoryImpl.getNotificationBoolean()

    private val _languages = MutableLiveData<LanguagesList>()
    val languages: LiveData<LanguagesList>
        get() = _languages

    init {
        getLanguages()
    }

    private suspend fun fetchLanguages() = flow {
        emit(profileRepositoryImpl.getLanguages())
    }

    private fun getLanguages() {
        viewModelScope.launch {
            fetchLanguages().collect{
                _languages.postValue(it)
            }
        }
    }
}
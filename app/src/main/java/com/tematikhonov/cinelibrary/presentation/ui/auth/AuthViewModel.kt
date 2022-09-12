package com.tematikhonov.cinelibrary.presentation.ui.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseUser
import com.tematikhonov.cinelibrary.domain.repositories.auth.AuthRepository
import com.tematikhonov.cinelibrary.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(private val repository: AuthRepository): ViewModel() {

    val currentUser: FirebaseUser?
        get() = repository.currentUser

    private val _signInWithEmailAndPassword = MutableStateFlow<Resource<FirebaseUser>?>(null)
    val signInWithEmailAndPassword: StateFlow<Resource<FirebaseUser>?> = _signInWithEmailAndPassword

    private val _createUserWithEmailAndPassword = MutableStateFlow<Resource<FirebaseUser>?>(null)
    val createUserWithEmailAndPassword: StateFlow<Resource<FirebaseUser>?> = _createUserWithEmailAndPassword

    private val _signInAnonymously = MutableStateFlow<Resource<FirebaseUser>?>(null)
    val signInAnonymously: StateFlow<Resource<FirebaseUser>?> = _signInAnonymously

    init {
        if (repository.currentUser != null) {
            _signInWithEmailAndPassword.value = Resource.Success(repository.currentUser!!)
        }
    }

    fun signInWithEmailAndPassword(login: String, password: String) = viewModelScope.launch {
        _signInWithEmailAndPassword.value = Resource.Loading
        val result = repository.signInWithEmailAndPassword(login, password)
        _signInWithEmailAndPassword.value = result
    }

    fun createUserWithEmailAndPassword(email: String, password: String) = viewModelScope.launch {
        _createUserWithEmailAndPassword.value = Resource.Loading
        val result = repository.createUserWithEmailAndPassword(email, password)
        _createUserWithEmailAndPassword.value = result
    }

    fun signInAnonymously() = viewModelScope.launch {
        _signInAnonymously.value = Resource.Loading
        val result = repository.signInAnonymously()
        _signInAnonymously.value = result
    }


    fun signOut() {
        repository.signOut()
        _signInWithEmailAndPassword.value = null
        _createUserWithEmailAndPassword.value = null
        _signInAnonymously.value = null
    }
}
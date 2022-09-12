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

    private val _firebaseSignInWithEmailAndPassword = MutableStateFlow<Resource<FirebaseUser>?>(null)
    val firebaseSignInWithEmailAndPassword: StateFlow<Resource<FirebaseUser>?> = _firebaseSignInWithEmailAndPassword

    private val _createUserWithEmailAndPassword = MutableStateFlow<Resource<FirebaseUser>?>(null)
    val createUserWithEmailAndPassword: StateFlow<Resource<FirebaseUser>?> = _createUserWithEmailAndPassword

    init {
        if (repository.currentUser != null) {
            _firebaseSignInWithEmailAndPassword.value = Resource.Success(repository.currentUser!!)
        }
    }

    fun firebaseSignInWithEmailAndPassword(login: String, password: String) = viewModelScope.launch {
        _firebaseSignInWithEmailAndPassword.value = Resource.Loading
        val result = repository.firebaseSignInWithEmailAndPassword(login, password)
        _firebaseSignInWithEmailAndPassword.value = result
    }

    fun createUserWithEmailAndPassword(email: String, password: String) = viewModelScope.launch {
        _createUserWithEmailAndPassword.value = Resource.Loading
        val result = repository.createUserWithEmailAndPassword(email, password)
        _createUserWithEmailAndPassword.value = result
    }


    fun signOut() {
        repository.signOut()
        _firebaseSignInWithEmailAndPassword.value = null
    }
}
package com.tematikhonov.cinelibrary.domain.repositories.auth

import com.google.firebase.auth.FirebaseUser
import com.tematikhonov.cinelibrary.utils.Resource

interface AuthRepository {
    val currentUser: FirebaseUser?

    suspend fun signInWithEmailAndPassword(login: String, password: String): Resource<FirebaseUser>

    suspend fun createUserWithEmailAndPassword(email: String, password: String): Resource<FirebaseUser>

    suspend fun signInAnonymously(): Resource<FirebaseUser>

    fun signOut()
}
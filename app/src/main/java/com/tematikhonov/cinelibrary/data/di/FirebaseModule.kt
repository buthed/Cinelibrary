package com.tematikhonov.cinelibrary.data.di

import com.google.firebase.auth.FirebaseAuth
import com.tematikhonov.cinelibrary.domain.repositories.auth.AuthRepository
import com.tematikhonov.cinelibrary.domain.repositories.auth.AuthRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object FirebaseModule {

    @Provides
    fun provideFirebaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()

    @Provides
    fun provideAuthRepository(impl: AuthRepositoryImpl): AuthRepository = impl
}
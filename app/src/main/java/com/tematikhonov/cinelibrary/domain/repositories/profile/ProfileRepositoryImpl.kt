package com.tematikhonov.cinelibrary.domain.repositories.profile

import android.content.Context

class ProfileRepositoryImpl(override val context: Context): ProfileRepository {

    override fun clearCache(context: Context) {
        context.cacheDir.deleteRecursively() //TODO Check work
    }
}
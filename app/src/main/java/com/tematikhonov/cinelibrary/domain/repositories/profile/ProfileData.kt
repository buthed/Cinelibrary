package com.tematikhonov.cinelibrary.domain.repositories.profile

import android.content.Context
import javax.inject.Inject

class ProfileData @Inject constructor(val context: Context) {

    fun clearCache() {
        context.cacheDir.deleteRecursively() //t
    }
}
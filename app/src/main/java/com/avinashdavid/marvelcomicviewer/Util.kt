package com.avinashdavid.marvelcomicviewer

import android.content.SharedPreferences
import android.os.Build
import androidx.preference.PreferenceManager
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys

fun marvelSharedPreferences() = PreferenceManager.getDefaultSharedPreferences(MainActivity.instance.get())

fun encryptedMarvelSharedPreferencesIfAvailable() : SharedPreferences {
    if (Build.VERSION.SDK_INT >= 23) {
        val keyGenParameterSpec = MasterKeys.AES256_GCM_SPEC
        val masterKeyAlias = MasterKeys.getOrCreate(keyGenParameterSpec)
        val fileName = "spot_sensitive_data.txt"
        return EncryptedSharedPreferences
            .create(
                fileName,
                masterKeyAlias,
                MainActivity.instance.get()!!,
                EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
                EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
            )
    } else {
        return marvelSharedPreferences()
    }
}
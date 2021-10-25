package com.avinashdavid.marvelcomicviewer

import android.content.SharedPreferences
import android.os.Build
import androidx.preference.PreferenceManager
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import org.apache.commons.codec.binary.Hex
import org.apache.commons.codec.digest.DigestUtils
import java.io.UnsupportedEncodingException
import java.lang.StringBuilder
import java.math.BigInteger
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import kotlin.experimental.and
import kotlin.experimental.or

fun marvelSharedPreferences() = PreferenceManager.getDefaultSharedPreferences(MainActivity.instance.get())

fun encryptedMarvelSharedPreferencesIfAvailable() : SharedPreferences {
    if (Build.VERSION.SDK_INT >= 23) {
        val keyGenParameterSpec = MasterKeys.AES256_GCM_SPEC
        val masterKeyAlias = MasterKeys.getOrCreate(keyGenParameterSpec)
        val fileName = "marvel_sensitive_data.txt"
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

fun makeMD5(md5: String): String {
//    var m: MessageDigest? = null
//
//    try {
//        m = MessageDigest.getInstance("MD5")
//    } catch (e: NoSuchAlgorithmException) {
//        e.printStackTrace()
//    }
//
//    m!!.update(md5.toByteArray(), 0, md5.length)
//    return BigInteger(1, m.digest()).toString(16)

    val MD5 = "MD5"
    try {
        // Create MD5 Hash
        val digest = MessageDigest
            .getInstance(MD5)
        digest.update(md5.toByteArray())
        val messageDigest = digest.digest()

        // Create Hex String
        val hexString = StringBuilder()
        for (aMessageDigest in messageDigest) {
            var h = Integer.toHexString(0xFF and aMessageDigest.toInt())
            while (h.length < 2) h = "0$h"
            hexString.append(h)
        }
        return hexString.toString()
    } catch (e: NoSuchAlgorithmException) {
        e.printStackTrace()
    }
    return ""

//    return String(Hex.encodeHex(DigestUtils.md5(md5)))
}
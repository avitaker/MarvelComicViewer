package com.avinashdavid.marvelcomicviewer

import android.content.SharedPreferences
import android.os.Build
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.preference.PreferenceManager
import org.apache.commons.codec.binary.Hex
import org.apache.commons.codec.digest.DigestUtils
import java.io.UnsupportedEncodingException
import java.lang.StringBuilder
import java.math.BigInteger
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import kotlin.experimental.and
import kotlin.experimental.or

fun makeMD5(md5: String): String {
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
}
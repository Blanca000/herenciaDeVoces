package com.example.herenciadevoces.ui.utils

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import java.io.InputStream

fun loadBitmapFromAssets(context: Context, assetPath: String): Bitmap? {
    return try {
        context.assets.open(assetPath).use { inputStream: InputStream ->
            BitmapFactory.decodeStream(inputStream)
        }
    } catch (e: Exception) {
        e.printStackTrace()
        null
    }
}

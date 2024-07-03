package com.ernestbg.phrasalverbs.utils

import android.content.Context
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream
import java.io.OutputStream

fun copyDatabase(context: Context, databaseName: String) {
    val dbPath = context.getDatabasePath(databaseName)

    if (!dbPath.exists()) {
        dbPath.parentFile?.mkdirs()

        val inputStream: InputStream = context.assets.open(databaseName)
        val outputStream: OutputStream = FileOutputStream(dbPath)

        val buffer = ByteArray(1024)
        var length: Int

        while (inputStream.read(buffer).also { length = it } > 0) {
            outputStream.write(buffer, 0, length)
        }

        outputStream.flush()
        outputStream.close()
        inputStream.close()
    }
}
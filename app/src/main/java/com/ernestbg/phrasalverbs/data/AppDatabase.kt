package com.ernestbg.phrasalverbs.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ernestbg.phrasalverbs.model.PhrasalVerb

@Database(entities = [PhrasalVerb::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun phrasalVerbDao(): PhrasalVerbDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "phrasal-verbs.db"
                ).createFromAsset("phrasal-verbs.db")
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}


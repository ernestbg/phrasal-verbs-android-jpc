package com.ernestbg.phrasalverbs.data

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ernestbg.phrasalverbs.model.Definition
import com.ernestbg.phrasalverbs.model.Example
import com.ernestbg.phrasalverbs.model.PhrasalVerb

@Database(entities = [PhrasalVerb::class, Definition::class, Example::class], version = 1, exportSchema = true)
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
                    "phrasal_verbs.db"
                )
                    .createFromAsset("phrasal_verbs.db")
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}



package com.ernestbg.phrasalverbs.di

import android.content.Context
import com.ernestbg.phrasalverbs.data.AppDatabase
import com.ernestbg.phrasalverbs.data.DefinitionDao
import com.ernestbg.phrasalverbs.data.PhrasalVerbDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return AppDatabase.getDatabase(appContext)
    }

    @Singleton
    @Provides
    fun providePhrasalVerbDao(db: AppDatabase): PhrasalVerbDao {
        return db.phrasalVerbDao()
    }

    @Singleton
    @Provides
    fun provideDefinitionDao(db: AppDatabase): DefinitionDao {
        return db.definitionDao()
    }
}

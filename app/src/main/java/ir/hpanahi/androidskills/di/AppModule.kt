package ir.hpanahi.androidskills.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ir.hpanahi.androidskills.C
import ir.hpanahi.androidskills.api.PexelsService
import ir.hpanahi.androidskills.data.AppDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext app: Context): AppDatabase {
        return Room.databaseBuilder(app, AppDatabase::class.java, C.APP_DATABASE_NAME).build()
    }

    @Singleton
    @Provides
    fun providePexelsService(): PexelsService {
        return PexelsService.create()
    }
}
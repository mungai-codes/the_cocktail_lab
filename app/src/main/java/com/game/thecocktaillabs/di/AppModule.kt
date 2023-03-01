package com.game.thecocktaillabs.di

import android.app.Application
import androidx.room.Room
import com.game.thecocktaillabs.common.Constants.BASE_URL
import com.game.thecocktaillabs.common.Constants.DATABASE_NAME
import com.game.thecocktaillabs.data.local.TheCocktailLabDatabase
import com.game.thecocktaillabs.data.remote.TheCocktailDbApiService
import com.game.thecocktaillabs.data.repository.TheCocktailLabRepositoryImpl
import com.game.thecocktaillabs.domain.repository.TheCocktailLabRepository
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @IoDispatcher
    @Provides
    fun provideIoDispatcher(): CoroutineDispatcher = Dispatchers.IO

    @Singleton
    @Provides
    fun provideApiService(): TheCocktailDbApiService {
        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(5000, TimeUnit.MILLISECONDS)
            .build()
        return Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .build()
            .create(TheCocktailDbApiService::class.java)
    }

    @Singleton
    @Provides
    fun provideTheAppDatabase(context: Application): TheCocktailLabDatabase {
        return Room.databaseBuilder(
            context = context,
            klass = TheCocktailLabDatabase::class.java,
            name = DATABASE_NAME
        ).build()
    }

    @Singleton
    @Provides
    fun provideTheRepository(
        apiService: TheCocktailDbApiService,
        database: TheCocktailLabDatabase
    ): TheCocktailLabRepository {
        return TheCocktailLabRepositoryImpl(apiService, database)
    }
}
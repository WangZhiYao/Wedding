package me.zhiyao.dress.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import me.zhiyao.dress.data.db.AppDatabase
import javax.inject.Singleton

/**
 *
 * @author WangZhiYao
 * @date 2021/1/17
 */
@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    private const val DB_NAME = "Dress.db"

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context) =
        Room.databaseBuilder(appContext, AppDatabase::class.java, DB_NAME)
            .build()

    @Provides
    fun provideDressDao(appDatabase: AppDatabase) = appDatabase.dressDao()

    @Provides
    fun provideDressImageDao(appDatabase: AppDatabase) = appDatabase.dressImageDao()

    @Provides
    fun provideCustomerDao(appDatabase: AppDatabase) = appDatabase.customerDao()

    @Provides
    fun provideReserveDao(appDatabase: AppDatabase) = appDatabase.reserveDao()

    @Provides
    fun provideRentalRecordDao(appDatabase: AppDatabase) = appDatabase.rentalRecordDao()

    @Provides
    fun provideFilterDao(appDatabase: AppDatabase) = appDatabase.filterDao()

    @Provides
    fun provideFilterOptionDao(appDatabase: AppDatabase) = appDatabase.filterOptionDao()

    @Provides
    fun provideDressFilterOptionDao(appDatabase: AppDatabase) = appDatabase.dressFilterOptionDao()

}
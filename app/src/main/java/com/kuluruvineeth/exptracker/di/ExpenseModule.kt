package com.kuluruvineeth.exptracker.di

import android.content.Context
import androidx.room.Room
import com.kuluruvineeth.exptracker.data.TransactionDao
import com.kuluruvineeth.exptracker.data.TransactionDatabase
import com.kuluruvineeth.exptracker.data.repository.DataStoreRepositoryImpl
import com.kuluruvineeth.exptracker.data.repository.TransactionRepositoryImpl
import com.kuluruvineeth.exptracker.domain.repository.DataStoreRepository
import com.kuluruvineeth.exptracker.domain.repository.TransactionRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ExpenseModule {

    @Provides
    @Singleton
    fun provideDatastoreRepository(@ApplicationContext context: Context): DataStoreRepository{
        return DataStoreRepositoryImpl(context)
    }

    @Provides
    @Singleton
    fun provideTransactionDao(database: TransactionDatabase) = database.transactionDao

    @Provides
    @Singleton
    fun provideTransactionRepository(transactionDao: TransactionDao): TransactionRepository{
        return TransactionRepositoryImpl(transactionDao)
    }

    @Provides
    @Singleton
    fun provideTransactionDatabase(@ApplicationContext context: Context): TransactionDatabase{
        return Room.databaseBuilder(context, TransactionDatabase::class.java, "transactionDB")
            .fallbackToDestructiveMigration()
            .build()
    }
}
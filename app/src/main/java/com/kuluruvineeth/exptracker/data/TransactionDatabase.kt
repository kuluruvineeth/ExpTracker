package com.kuluruvineeth.exptracker.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.kuluruvineeth.exptracker.data.local.converters.DateConverter
import com.kuluruvineeth.exptracker.data.local.entity.AccountDto
import com.kuluruvineeth.exptracker.data.local.entity.TransactionDto


@TypeConverters(value = [DateConverter::class])
@Database(
    entities = [
        TransactionDto::class,
        AccountDto::class
    ],
    exportSchema = true,
    version = 1
)
abstract class TransactionDatabase : RoomDatabase(){
    abstract val transactionDao: TransactionDao
}
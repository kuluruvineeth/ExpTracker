package com.kuluruvineeth.exptracker.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.kuluruvineeth.exptracker.domain.models.Account

@Entity(tableName = "accounts_table")
data class AccountDto(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id")
    val id: String,
    @ColumnInfo(name = "account")
    val accountType: String,
    @ColumnInfo(name = "balance")
    val balance: Double,
    @ColumnInfo(name = "income")
    val income: Double,
    @ColumnInfo(name = "expense")
    val expense: Double
){

    fun toAccount() : Account = Account(accountType,balance,income,expense)
}

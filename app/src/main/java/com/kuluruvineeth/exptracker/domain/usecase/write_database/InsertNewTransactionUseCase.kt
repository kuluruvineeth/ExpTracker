package com.kuluruvineeth.exptracker.domain.usecase.write_database

import com.kuluruvineeth.exptracker.data.local.entity.TransactionDto
import com.kuluruvineeth.exptracker.domain.repository.TransactionRepository
import javax.inject.Inject

class InsertNewTransactionUseCase @Inject constructor(
    private val transactionRepository: TransactionRepository
) {

    suspend operator fun invoke(dailyExpense: TransactionDto){
        transactionRepository.insertTransaction(dailyExpense)
    }
}
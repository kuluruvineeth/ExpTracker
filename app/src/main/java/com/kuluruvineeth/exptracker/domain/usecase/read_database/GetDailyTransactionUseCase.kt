package com.kuluruvineeth.exptracker.domain.usecase.read_database

import com.kuluruvineeth.exptracker.data.local.entity.TransactionDto
import com.kuluruvineeth.exptracker.domain.repository.TransactionRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetDailyTransactionUseCase @Inject constructor(
    private val transactionRepository: TransactionRepository
) {

    operator fun invoke(entryDate: String): Flow<List<TransactionDto>>{
        return transactionRepository.getDailyTransaction(entryDate)
    }
}
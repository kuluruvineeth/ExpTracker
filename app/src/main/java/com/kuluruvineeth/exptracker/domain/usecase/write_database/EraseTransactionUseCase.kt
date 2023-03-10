package com.kuluruvineeth.exptracker.domain.usecase.write_database

import com.kuluruvineeth.exptracker.domain.repository.TransactionRepository
import javax.inject.Inject

class EraseTransactionUseCase @Inject constructor(
    private val transactionRepository: TransactionRepository
) {

    operator fun invoke(){
        transactionRepository.eraseTransaction()
    }
}
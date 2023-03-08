package com.kuluruvineeth.exptracker.domain.usecase.read_database

import com.kuluruvineeth.exptracker.data.local.entity.AccountDto
import com.kuluruvineeth.exptracker.domain.repository.TransactionRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAccountsUseCase @Inject constructor(
    private val transactionRepository: TransactionRepository
) {

    operator fun invoke(): Flow<List<AccountDto>>{
        return transactionRepository.getAccounts()
    }
}
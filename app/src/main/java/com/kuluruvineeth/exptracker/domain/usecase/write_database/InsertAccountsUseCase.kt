package com.kuluruvineeth.exptracker.domain.usecase.write_database

import com.kuluruvineeth.exptracker.data.local.entity.AccountDto
import com.kuluruvineeth.exptracker.domain.repository.TransactionRepository
import javax.inject.Inject

class InsertAccountsUseCase @Inject constructor(
    private val transactionRepository: TransactionRepository
) {

    suspend operator fun invoke(accounts: List<AccountDto>){
        transactionRepository.insertAccount(accounts)
    }
}
package com.kuluruvineeth.exptracker.domain.usecase.write_datastore

import com.kuluruvineeth.exptracker.domain.repository.DataStoreRepository
import javax.inject.Inject

class EditExpenseLimitUseCase @Inject constructor(
    private val dataStoreRepository: DataStoreRepository
) {

    suspend operator fun invoke(amount: Double){
        dataStoreRepository.writeExpenseLimitToDatastore(amount)
    }
}
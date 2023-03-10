package com.kuluruvineeth.exptracker.domain.usecase.write_datastore

import com.kuluruvineeth.exptracker.domain.repository.DataStoreRepository
import javax.inject.Inject

class EditLimitKeyUseCase @Inject constructor(
    private val dataStoreRepository: DataStoreRepository
) {

    suspend operator fun invoke(enabled: Boolean){
        dataStoreRepository.writeLimitKeyToDatastore(enabled)
    }
}
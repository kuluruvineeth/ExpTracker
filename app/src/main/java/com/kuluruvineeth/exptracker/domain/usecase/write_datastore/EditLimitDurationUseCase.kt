package com.kuluruvineeth.exptracker.domain.usecase.write_datastore

import com.kuluruvineeth.exptracker.domain.repository.DataStoreRepository
import javax.inject.Inject

class EditLimitDurationUseCase @Inject constructor(
    private val dataStoreRepository: DataStoreRepository
) {

    suspend operator fun invoke(duration: Int){
        dataStoreRepository.writeLimitDurationToDatastore(duration)
    }
}
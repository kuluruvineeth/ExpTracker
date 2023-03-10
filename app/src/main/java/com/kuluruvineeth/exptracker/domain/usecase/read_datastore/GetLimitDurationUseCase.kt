package com.kuluruvineeth.exptracker.domain.usecase.read_datastore

import com.kuluruvineeth.exptracker.domain.repository.DataStoreRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetLimitDurationUseCase @Inject constructor(
    private val dataStoreRepository: DataStoreRepository
) {

    suspend operator fun invoke() : Flow<Int>{
        return dataStoreRepository.readLimitDurationFromDatastore()
    }
}
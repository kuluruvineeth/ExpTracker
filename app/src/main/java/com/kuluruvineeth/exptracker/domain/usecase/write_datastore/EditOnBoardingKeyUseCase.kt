package com.kuluruvineeth.exptracker.domain.usecase.write_datastore

import com.kuluruvineeth.exptracker.domain.repository.DataStoreRepository
import javax.inject.Inject

class EditOnBoardingKeyUseCase @Inject constructor(
    private val dataStoreRepository: DataStoreRepository
) {

    suspend operator fun invoke(completed: Boolean){
        dataStoreRepository.writeOnboardingKeyToDatastore(completed)
    }
}
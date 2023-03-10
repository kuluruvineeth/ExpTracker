package com.kuluruvineeth.exptracker.domain.usecase.write_datastore

import com.kuluruvineeth.exptracker.domain.repository.DataStoreRepository
import javax.inject.Inject

class EditCurrencyUseCase @Inject constructor(
    private val dataStoreRepository: DataStoreRepository
) {

    suspend operator fun invoke(currency: String){
        dataStoreRepository.writeCurrencyToDatastore(currency)
    }
}
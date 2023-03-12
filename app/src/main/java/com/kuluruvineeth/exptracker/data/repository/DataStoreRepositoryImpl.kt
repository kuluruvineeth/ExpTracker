package com.kuluruvineeth.exptracker.data.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import com.kuluruvineeth.exptracker.common.Constants
import com.kuluruvineeth.exptracker.domain.repository.DataStoreRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


val Context.datastore : DataStore<Preferences> by preferencesDataStore(name = "expense_key_store")

class DataStoreRepositoryImpl @Inject constructor(
    context: Context
) : DataStoreRepository{

    private val datastore = context.datastore
    private val onBoardingKey = booleanPreferencesKey(Constants.WELCOME_KEY)
    private val limitKey = booleanPreferencesKey(Constants.LIMIT_KEY)
    private val selectedCurrency = stringPreferencesKey(Constants.CURRENCY_KEY)
    private val expenseLimit = doublePreferencesKey(Constants.EXPENSE_LIMIT_KEY)
    private val limitDuration = intPreferencesKey(Constants.LIMIT_DURATION)



    override suspend fun writeOnboardingKeyToDatastore(completed: Boolean) {
        datastore.edit { store ->
            store[onBoardingKey] = completed
        }
    }

    override suspend fun readOnboardingKeyFromDataStore(): Flow<Boolean> {
        val preferences = datastore.data
        return flow {
            preferences.collect{pref ->
                emit(pref[onBoardingKey] ?: false)
            }
        }
    }

    override suspend fun writeCurrencyToDatastore(currency: String) {
        datastore.edit { store ->
            store[selectedCurrency] = currency
        }
    }

    override suspend fun readCurrencyFromDatastore(): Flow<String> {
        val preferences = datastore.data
        return flow {
            preferences.collect{pref ->
                emit(pref[selectedCurrency] ?: String())
            }
        }
    }

    override suspend fun writeExpenseLimitToDatastore(amount: Double) {
        datastore.edit { store ->
            store[expenseLimit] = amount
        }
    }

    override suspend fun readExpenseLimitFromDatastore(): Flow<Double> {
        val preferences = datastore.data
        return flow {
            preferences.collect{pref ->
                emit(pref[expenseLimit] ?: 0.0)
            }
        }
    }

    override suspend fun writeLimitKeyToDatastore(enabled: Boolean) {
        datastore.edit { store ->
            store[limitKey] = enabled
        }
    }

    override suspend fun readLimitKeyFromDatastore(): Flow<Boolean> {
        val preferences = datastore.data
        return flow {
            preferences.collect{pref ->
                emit(pref[limitKey] ?: false)
            }
        }
    }

    override suspend fun writeLimitDurationToDatastore(duration: Int) {
        datastore.edit { store ->
            store[limitDuration] = duration
        }
    }

    override suspend fun readLimitDurationFromDatastore(): Flow<Int> {
        val preferences = datastore.data
        return flow {
            preferences.collect{pref ->
                emit(pref[limitDuration] ?: 0)
            }
        }
    }

    override suspend fun eraseDatastore() {
        datastore.edit {
            it.remove(limitKey)
            it.remove(limitDuration)
            it.remove(expenseLimit)
        }
    }
}
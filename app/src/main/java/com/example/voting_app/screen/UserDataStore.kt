package com.example.voting_app.screen

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


class UserDataStore(context: Context) {
    private val Context.dataStore by preferencesDataStore("user_prefs")
    private val dataStore = context.dataStore

    companion object {
        val EMAIL_KEY = stringPreferencesKey("email")
    }

    suspend fun saveLoginState(email: String) {
        dataStore.edit { prefs ->
            prefs[EMAIL_KEY] = email
        }
    }

    val getLoginState: Flow<String?> = dataStore.data.map { prefs ->
        prefs[EMAIL_KEY]
    }
}

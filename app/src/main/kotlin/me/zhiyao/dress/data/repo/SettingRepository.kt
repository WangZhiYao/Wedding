package me.zhiyao.dress.data.repo

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import me.zhiyao.dress.constant.DataStoreKey
import me.zhiyao.dress.constant.OrderBy
import java.io.IOException
import javax.inject.Inject

/**
 *
 * @author WangZhiYao
 * @date 2021/1/25
 */
class SettingRepository @Inject constructor(
    private val dataStore: DataStore<Preferences>
) {

    val sortOrder: Flow<Int> = dataStore.data.catch { exception ->
        if (exception is IOException) {
            emit(emptyPreferences())
        } else {
            throw exception
        }
    }.map { preferences ->
        preferences[DataStoreKey.DRESS_SORT_ORDER] ?: OrderBy.CREATE_TIME_DESC
    }

    suspend fun setSortOrder(@OrderBy order: Int) {
        dataStore.edit { preferences ->
            preferences[DataStoreKey.DRESS_SORT_ORDER] = order
        }
    }
}
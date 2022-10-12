package epic.legofullstack.fourpaws.core.domain.usecase

import epic.legofullstack.fourpaws.core.di.DispatchersModule
import epic.legofullstack.fourpaws.core.domain.mapper.toArea
import epic.legofullstack.fourpaws.core.domain.model.Area
import epic.legofullstack.fourpaws.core.domain.model.toAreaModel
import epic.legofullstack.fourpaws.core.domain.repository.UserAreaDataStoreRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PreferenceDataStoreUseCase @Inject constructor(
    private val dataStore: UserAreaDataStoreRepository,
    @DispatchersModule.IoDispatcher
    private val ioDispatcher: CoroutineDispatcher
) {

    suspend fun getUserArea(): Flow<Area> =
        withContext(ioDispatcher) {
            return@withContext dataStore.getUserArea().map { pref -> pref.toArea() }
        }

    suspend fun saveUserArea(area: Area) = dataStore.saveUserArea(area.toAreaModel())
}
package epic.legofullstack.fourpaws.feature.home.data.repository

import epic.legofullstack.fourpaws.feature.home.data.model.PetDto
import epic.legofullstack.fourpaws.feature.home.data.storage.HomePageLocalDataSource
import epic.legofullstack.fourpaws.feature.home.domain.repository.PetsRepository
import epic.legofullstack.fourpaws.network.firebase.data.FirebaseDataSource

/**
 * Реализация интерфейса репозитория
 * В будущем добавится RemoteDataSource для работы с сетью
 * Пока что только LocalDataSource с фейковыми данными
 *
 * @author Asanov Albek in 16.09.2022
 */
class PetsRepositoryImpl(
    private val localDataSource: HomePageLocalDataSource,
    private val remoteDataSource: FirebaseDataSource
) : PetsRepository {
    override suspend fun getAllPets(areaId: Int): List<PetDto> {
        val petsByArea = remoteDataSource.getObjectsByFieldName(FIELD_AREA_ID, areaId, PET_COLLECTION, PetDto::class.java)
        return petsByArea.map { TODO("реализовать мапинг в PetDto") }
    }

    companion object {
        private const val FIELD_AREA_ID = "areaId"
        private const val PET_COLLECTION = "pet"
    }
}
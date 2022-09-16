package epic.legofullstack.fourpaws.feature_home_page.data.model

/**
 * Модель для представления питомцев
 * @param petId - уникальный id питомца
 * @param name - кличка питомца
 */
data class PetDto (
    val petId : Int,
    val name : String
)
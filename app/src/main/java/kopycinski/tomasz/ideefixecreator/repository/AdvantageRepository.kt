package kopycinski.tomasz.ideefixecreator.repository

import kopycinski.tomasz.ideefixecreator.database.dao.AdvantageDao
import kopycinski.tomasz.ideefixecreator.database.entity.Advantage
import kopycinski.tomasz.ideefixecreator.database.entity.CharacterSheetAdvantageCrossRef
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AdvantageRepository @Inject constructor(
    private val advantageDao: AdvantageDao
) {
    suspend fun insertAdvCharCrossRef(characterId: Long, advantageId: Long, level: Int, cost: Int) =
        advantageDao.insertAdvCharCrossRef(CharacterSheetAdvantageCrossRef(characterId, advantageId, level, cost))

    suspend fun updateAdvCharCrossRef(crossRef: CharacterSheetAdvantageCrossRef) =
        advantageDao.updateAdvCharCrossRef(crossRef)

    suspend fun removeAdvCharCrossRef(characterId: Long, advantageId: Long) =
        advantageDao.removeAdvCharCrossRef(advantageId, characterId)

    fun getAdvantages(): Flow<List<Advantage>> =
        advantageDao.getAll()

    fun getAdvantageIdsByCharacterId(characterId: Long): Flow<List<CharacterSheetAdvantageCrossRef>> =
        advantageDao.getIdsAddedToCharacterSheet(characterId)
}
package kopycinski.tomasz.ideefixecreator.database.repository

import kopycinski.tomasz.ideefixecreator.database.dao.CharacterSheetDao
import kopycinski.tomasz.ideefixecreator.database.entity.CharacterSheet
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CharacterSheetRepository @Inject constructor(
    private val characterSheetDao: CharacterSheetDao
) {
    suspend fun insertCharacterSheet(characterSheet: CharacterSheet) =
        characterSheetDao.insertAll(characterSheet)

    suspend fun updateCharacterSheet(characterSheet: CharacterSheet) =
        characterSheetDao.updateAll(characterSheet)

    fun getCharacterSheet(id: Long): Flow<CharacterSheet> =
        characterSheetDao.getOne(id)
}
package kopycinski.tomasz.ideefixecreator.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kopycinski.tomasz.ideefixecreator.database.entity.CharacterSheet
import kopycinski.tomasz.ideefixecreator.database.repository.CharacterSheetRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterCreateViewModel @Inject constructor(
    private val characterSheetRepository: CharacterSheetRepository
) : ViewModel() {

    private var didLoad = false
    private val _characterSheet = MutableStateFlow(CharacterSheet())
    val characterSheet = _characterSheet.asStateFlow()

    fun getCharacterSheet(id: Long) {
        if (!didLoad) {
            viewModelScope.launch {
                characterSheetRepository.getOrCreateCharacter(id).collect { characterSheet ->
                    didLoad = true
                    _characterSheet.value = characterSheet
                }
            }
        }
    }

    fun insertCharacterSheet(characterSheet: CharacterSheet) {
        viewModelScope.launch {
            characterSheetRepository.insertCharacterSheet(characterSheet)
        }
    }
}
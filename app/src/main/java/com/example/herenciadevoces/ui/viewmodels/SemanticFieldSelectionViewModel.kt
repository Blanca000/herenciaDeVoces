package com.example.herenciadevoces.ui.viewmodels

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.herenciadevoces.domain.SemanticField.usecase.GetSemanticFields
import com.example.herenciadevoces.ui.interaction.semanticFieldState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class SemanticFieldSelectionViewModel @Inject constructor(
    private val getSemanticFields: GetSemanticFields
) : ViewModel() {
    private val _state = mutableStateOf(semanticFieldState())
    private val _selectedLanguagesVariants = mutableStateOf<List<Int>>(emptyList())
    val state: State<semanticFieldState> = _state
    val selectedLanguagesVariants: State<List<Int>> = _selectedLanguagesVariants

    init {
        collectSemanticFields()
    }

    private fun collectSemanticFields() {
        viewModelScope.launch(Dispatchers.IO) {
            val fetchedSemanticFields = getSemanticFields()
            withContext(Dispatchers.Main) {
                _state.value = _state.value.copy(semanticField = fetchedSemanticFields)
            }
        }
    }

    fun toggleSelection(idVariant: Int) {
        val currentVariants = _selectedLanguagesVariants.value.toMutableList()
        if (currentVariants.contains(idVariant)) {
            currentVariants.remove(idVariant)
            Log.d("VARIANT SELECTION", currentVariants.toString())
        } else {
            currentVariants.add(idVariant)
            Log.d("VARIANT SELECTION", currentVariants.toString())
        }
        _selectedLanguagesVariants.value = currentVariants.toList()
    }

}

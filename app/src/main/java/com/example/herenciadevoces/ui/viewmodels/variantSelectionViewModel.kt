package com.example.herenciadevoces.ui.viewmodels

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.herenciadevoces.domain.languageVariant.usecase.GetLanguageVariants
import com.example.herenciadevoces.ui.interaction.languageVariantState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class variantSelectionViewModel @Inject constructor(
    private val getLanguagesVariants : GetLanguageVariants
) : ViewModel() {
    private val _state = mutableStateOf(languageVariantState())
    private val _selectedLanguageVariants = MutableStateFlow<List<Int>>(emptyList())
    val state: State<languageVariantState> = _state
    val selectedLanguageVariants = _selectedLanguageVariants.asStateFlow()
    val isLoading = mutableStateOf(true) // Estado de carga inicial

    init {
        collectLanguageVariants()
    }

    private fun collectLanguageVariants(){
        viewModelScope.launch (Dispatchers.IO) {
            withContext(Dispatchers.Main){
                isLoading.value = true;
            }
            try {
                val fetchedLanguageVariants = getLanguagesVariants()
                Log.d("LANGUAGE VARIANTS", fetchedLanguageVariants.toString())
                withContext(Dispatchers.Main){
                    _state.value = _state.value.copy(languageVariants = fetchedLanguageVariants )
                    isLoading.value = false;
                }
            }catch (e: Exception) {
                withContext(Dispatchers.Main){
                    isLoading.value = false;
                }
                Log.e("VariantViewModel", "Error loading language variants", e)
            }

        }
    }

    fun toggleSelection(idVariant: Int) {
        val currentVariants = _selectedLanguageVariants.value.toMutableList()
        if (currentVariants.contains(idVariant)) {
            currentVariants.remove(idVariant)
            Log.d("VARIANT SELECTION", currentVariants.toString())
        } else {
            currentVariants.add(idVariant)
            Log.d("VARIANT SELECTION", currentVariants.toString())
        }
        _selectedLanguageVariants.value = currentVariants.toList()
    }
}

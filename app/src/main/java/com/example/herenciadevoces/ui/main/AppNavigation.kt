package com.example.herenciadevoces.ui.main

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.herenciadevoces.domain.SemanticField.model.SemanticField
import com.example.herenciadevoces.ui.viewmodels.variantSelectionViewModel
import com.example.herenciadevoces.ui.views.semanticFieldSelectionScreen
import com.example.herenciadevoces.ui.views.variantSelectionScreen
import com.example.herenciadevoces.ui.views.wordSoundsScreen
import kotlinx.serializacion.Serializable

@Serializable
object variantSelection

@Serializable
object semanticFieldSelection

@Serializable
data class wordSounds(val idsVariants: List<Int>, val idSemanticField: Int)

@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    val variantSelectionViewModel : variantSelectionViewModel = hiltViewModel()
    val listIdsVariants = remember { mutableStateListOf<Int>() }
    NavHost(
        navController = navController,
        startDestination = variantSelection
    ){
        composable<variantSelection>{
            variantSelectionScreen(variantSelectionViewModel){
                idsVariants -> navController.navigate(semanticFieldSelection)
                listIdsVariants.clear()
                listIdsVariants.addAll(idsVariants)
                Log.d("LIST IDS VARIANTS ", listIdsVariants.toString())
            }
        }



        composable<semanticFieldSelection>{
            SemanticFieldSelectionScreen{
                idSemanticField -> navController.navigate(wordSounds(idsVariants = listIdsVariants.toList(),idSemanticField = idSemanticField))
            }
        }

        composable<wordSounds>{
            wordSounds()
        }
    }

}
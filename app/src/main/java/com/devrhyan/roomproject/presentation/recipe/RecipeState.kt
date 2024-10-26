package com.devrhyan.roomproject.presentation.recipe

import com.devrhyan.roomproject.domain.model.RecipeModel

sealed interface RecipeState {
    object Loading: RecipeState
    object Empty: RecipeState
    data class Sucess(val recipe : List<RecipeModel>) : RecipeState
    data class Error(val message : String) : RecipeState
}
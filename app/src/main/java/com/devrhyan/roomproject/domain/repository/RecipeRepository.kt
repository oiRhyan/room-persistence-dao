package com.devrhyan.roomproject.domain.repository

import com.devrhyan.roomproject.domain.model.Recipe
import com.devrhyan.roomproject.domain.model.RecipeModel

interface RecipeRepository {

    suspend fun getAllRecipe() : List<RecipeModel>

    suspend fun insert(recipe : RecipeModel)
}
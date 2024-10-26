package com.devrhyan.roomproject.domain.usecase

import com.devrhyan.roomproject.data.entity.RecipeEntity
import com.devrhyan.roomproject.domain.model.Recipe
import com.devrhyan.roomproject.domain.model.RecipeModel
import com.devrhyan.roomproject.domain.repository.RecipeRepository

class InsertRecipeUseCase(
    private val repository : RecipeRepository
) {
    suspend operator fun invoke(recipe : RecipeModel) = repository.insert(recipe)
}
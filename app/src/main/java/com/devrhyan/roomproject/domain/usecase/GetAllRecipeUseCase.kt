package com.devrhyan.roomproject.domain.usecase

import com.devrhyan.roomproject.domain.model.Recipe
import com.devrhyan.roomproject.domain.repository.RecipeRepository

class GetAllRecipeUseCase(
    private val repository : RecipeRepository
) {
   suspend operator fun invoke() = repository.getAllRecipe()
}
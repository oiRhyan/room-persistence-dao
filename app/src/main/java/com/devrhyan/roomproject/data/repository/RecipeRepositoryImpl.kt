package com.devrhyan.roomproject.data.repository

import com.devrhyan.roomproject.data.dao.RecipeDAO
import com.devrhyan.roomproject.data.mapper.toEntity
import com.devrhyan.roomproject.data.mapper.toModel
import com.devrhyan.roomproject.domain.model.RecipeModel
import com.devrhyan.roomproject.domain.repository.RecipeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RecipeRepositoryImpl(
    private val dao : RecipeDAO
) : RecipeRepository {

    override suspend fun getAllRecipe(): List<RecipeModel> = withContext(Dispatchers.IO) {
        dao.getAllRecipes().map {
            it.toModel()
        }
    }

    override suspend fun insert(recipe: RecipeModel) = withContext(Dispatchers.IO) {
        dao.insertRecipe(recipe = recipe.toEntity())
    }

}
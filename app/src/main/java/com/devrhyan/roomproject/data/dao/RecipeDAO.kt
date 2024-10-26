package com.devrhyan.roomproject.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.devrhyan.roomproject.data.entity.RecipeEntity

@Dao
interface RecipeDAO {

    @Query("SELECT * FROM recipe")
    fun getAllRecipes() : List<RecipeEntity>

    @Insert
    fun insertRecipe(recipe : RecipeEntity)
}
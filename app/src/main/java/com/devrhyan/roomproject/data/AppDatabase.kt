package com.devrhyan.roomproject.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.devrhyan.roomproject.data.dao.RecipeDAO
import com.devrhyan.roomproject.data.entity.Recipe
import com.devrhyan.roomproject.data.entity.RecipeEntity

@Database(entities = [
    RecipeEntity::class
], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract  fun recipeDao() : RecipeDAO
}
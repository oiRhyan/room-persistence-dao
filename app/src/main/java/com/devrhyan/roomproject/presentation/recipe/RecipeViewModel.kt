package com.devrhyan.roomproject.presentation.recipe

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.devrhyan.roomproject.domain.model.RecipeModel
import com.devrhyan.roomproject.domain.usecase.GetAllRecipeUseCase
import com.devrhyan.roomproject.domain.usecase.InsertRecipeUseCase
import kotlinx.coroutines.launch

class RecipeViewModel(
    private val getAllRecipeUseCase: GetAllRecipeUseCase,
    private val insertRecipeUseCase: InsertRecipeUseCase
) : ViewModel() {

    val state : LiveData<RecipeState> = liveData {
         emit(RecipeState.Loading)
         val state = try {
             val recipes = getAllRecipeUseCase()
             if(recipes.isEmpty()) {
                 RecipeState.Empty
             } else {
                 RecipeState.Sucess(recipes)
             }
         } catch (e : Exception) {
             Log.e("Error", "${e.message}")
             RecipeState.Error(e.message.toString())
         }
        emit(state)
    }

    fun insert(name : String) = viewModelScope.launch {
        insertRecipeUseCase(RecipeModel(name = name))
    }


}
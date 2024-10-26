package com.devrhyan.roomproject.data.mapper

import com.devrhyan.roomproject.data.entity.RecipeEntity
import com.devrhyan.roomproject.domain.model.RecipeModel

fun RecipeModel.toEntity() = RecipeEntity(
    id = id,
    name = name
)

fun RecipeEntity.toModel() = RecipeModel(
    id = id,
    name = name
)
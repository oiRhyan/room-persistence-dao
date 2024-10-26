package com.devrhyan.roomproject.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.devrhyan.roomproject.R
import com.devrhyan.roomproject.domain.model.RecipeModel

class RecipeAdapter : ListAdapter<RecipeModel, RecipeAdapter.RecipeViewHolder>(RecipeDiffCallback()) {

    inner class RecipeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val recipeTitle: TextView = view.findViewById(R.id.recipeTitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val layoutConstructor = layoutInflater.inflate(R.layout.recycler_view_item, parent, false)
        return RecipeViewHolder(layoutConstructor)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val recipe = getItem(position)
        holder.recipeTitle.text = recipe.name
    }
}

class RecipeDiffCallback : DiffUtil.ItemCallback<RecipeModel>() {
    override fun areItemsTheSame(oldItem: RecipeModel, newItem: RecipeModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: RecipeModel, newItem: RecipeModel): Boolean {
        return oldItem == newItem
    }
}

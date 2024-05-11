package com.mironov.mironovtesttask.ui.pokemon_list

import androidx.recyclerview.widget.DiffUtil
import com.mironov.mironovtesttask.domain.entity.PokemonItem

class PokemonDiffUtil: DiffUtil.ItemCallback<PokemonItem>() {

    override fun areItemsTheSame(oldItem: PokemonItem, newItem: PokemonItem): Boolean =
        oldItem.name == newItem.name

    override fun areContentsTheSame(oldItem: PokemonItem, newItem: PokemonItem): Boolean =
        oldItem == newItem
}
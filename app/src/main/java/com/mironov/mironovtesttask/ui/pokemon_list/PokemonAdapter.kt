package com.mironov.mironovtesttask.ui.pokemon_list

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.mironov.mironovtesttask.domain.entity.PokemonItem

class PokemonAdapter : ListAdapter<PokemonItem, PokemonViewHolder>(PokemonDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder =
        PokemonViewHolder(parent)

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
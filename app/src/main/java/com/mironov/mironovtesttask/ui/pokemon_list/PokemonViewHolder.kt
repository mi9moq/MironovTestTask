package com.mironov.mironovtesttask.ui.pokemon_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.mironov.mironovtesttask.R
import com.mironov.mironovtesttask.databinding.PokemonItemBinding
import com.mironov.mironovtesttask.domain.entity.PokemonItem

class PokemonViewHolder(
    parent: ViewGroup
): RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.pokemon_item, parent, false)
) {

    private val binding = PokemonItemBinding.bind(itemView)

    fun bind(pokemon: PokemonItem) {
        with(binding) {
            name.text = pokemon.name
            icon.load(pokemon.iconUrl)
        }
    }
}
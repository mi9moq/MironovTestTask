package com.mironov.mironovtesttask.ui.pokemon_list

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import com.mironov.mironovtesttask.databinding.FragmentPokemonBinding
import com.mironov.mironovtesttask.domain.entity.PokemonItem
import com.mironov.mironovtesttask.presentation.pokemon_list.PokemonsCommand
import com.mironov.mironovtesttask.presentation.pokemon_list.PokemonsEffect
import com.mironov.mironovtesttask.presentation.pokemon_list.PokemonsEvent
import com.mironov.mironovtesttask.presentation.pokemon_list.PokemonsState
import com.mironov.mironovtesttask.ui.utils.ElmBaseFragment
import com.mironov.mironovtesttask.ui.utils.appComponent
import com.mironov.mironovtesttask.ui.utils.hide
import com.mironov.mironovtesttask.ui.utils.show
import vivid.money.elmslie.android.renderer.elmStoreWithRenderer
import vivid.money.elmslie.core.store.ElmStore
import vivid.money.elmslie.core.store.Store
import javax.inject.Inject

class PokemonsFragment : ElmBaseFragment<PokemonsEffect, PokemonsState, PokemonsEvent>() {

    private var _binding: FragmentPokemonBinding? = null
    private val binding: FragmentPokemonBinding
        get() = _binding!!

    private val component by lazy {
        requireContext().appComponent().getPokemonsComponentFactory().create()
    }

    @Inject
    lateinit var pokemonsStore: ElmStore<PokemonsEvent, PokemonsState, PokemonsEffect, PokemonsCommand>

    override val store: Store<PokemonsEvent, PokemonsEffect, PokemonsState> by elmStoreWithRenderer(
        elmRenderer = this
    ) {
        pokemonsStore
    }

    private val adapter by lazy {
        PokemonAdapter(
            ::openPokemon
        )
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        component.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPokemonBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setupClickListeners()
        store.accept(PokemonsEvent.Ui.Init)
    }

    private fun setupRecyclerView() {
        binding.content.adapter = adapter
    }

    private fun setupClickListeners() {
        binding.tryAgain.setOnClickListener {
            store.accept(PokemonsEvent.Ui.Refresh)
        }
    }

    override fun render(state: PokemonsState) {

        if (state.isLoading) applyLoadingState()

        state.content?.let {
            applyContentState(it)
        }
    }

    override fun handleEffect(effect: PokemonsEffect): Unit = when (effect) {
        PokemonsEffect.Error -> applyErrorState()
    }

    private fun applyContentState(items: List<PokemonItem>) {
        binding.shimmer.hide()
        binding.tryAgain.isVisible = false
        binding.errorMessage.isVisible = false
        adapter.submitList(items)
    }

    private fun applyLoadingState() {
        binding.shimmer.show()
        binding.tryAgain.isVisible = false
        binding.errorMessage.isVisible = false
    }

    private fun applyErrorState() {
        binding.shimmer.hide()
        binding.tryAgain.isVisible = true
        binding.errorMessage.isVisible = true
    }

    private fun openPokemon(name: String) {
        store.accept(PokemonsEvent.Ui.OnItemClicked(name))
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
package com.mironov.mironovtesttask.ui.details

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import coil.load
import com.mironov.mironovtesttask.R
import com.mironov.mironovtesttask.databinding.FragmentDetailsBinding
import com.mironov.mironovtesttask.domain.entity.PokemonDetail
import com.mironov.mironovtesttask.presentation.detail.DetailCommand
import com.mironov.mironovtesttask.presentation.detail.DetailEffect
import com.mironov.mironovtesttask.presentation.detail.DetailEvent
import com.mironov.mironovtesttask.presentation.detail.DetailState
import com.mironov.mironovtesttask.ui.utils.ElmBaseFragment
import com.mironov.mironovtesttask.ui.utils.appComponent
import com.mironov.mironovtesttask.ui.utils.hide
import com.mironov.mironovtesttask.ui.utils.show
import vivid.money.elmslie.android.renderer.elmStoreWithRenderer
import vivid.money.elmslie.core.store.ElmStore
import vivid.money.elmslie.core.store.Store
import javax.inject.Inject

class DetailFragment : ElmBaseFragment<DetailEffect, DetailState, DetailEvent>() {

    companion object {
        fun newInstance(pokemonName: String) = DetailFragment().apply {
            arguments = Bundle().apply {
                putString(POKEMON_NAME_KEY, pokemonName)
            }
        }

        private const val POKEMON_NAME_KEY = "pokemon name"
        private const val NO_NAME = ""
    }

    private var _binding: FragmentDetailsBinding? = null
    private val binding: FragmentDetailsBinding
        get() = _binding!!

    private val component by lazy {
        requireContext().appComponent().getDetailComponentFactory().create()
    }

    @Inject
    lateinit var detailStore: ElmStore<DetailEvent, DetailState, DetailEffect, DetailCommand>

    override val store: Store<DetailEvent, DetailEffect, DetailState> by elmStoreWithRenderer(
        elmRenderer = this
    ) {
        detailStore
    }

    private var pokemonName = NO_NAME

    override fun onAttach(context: Context) {
        super.onAttach(context)
        component.inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parseArguments()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar()
        store.accept(DetailEvent.Ui.Init(pokemonName))
    }

    private fun parseArguments() {
        val args = requireArguments()
        pokemonName = args.getString(POKEMON_NAME_KEY, NO_NAME)
    }

    private fun initToolbar() {
        binding.toolbar.title = pokemonName
        binding.toolbar.setNavigationOnClickListener {
            store.accept(DetailEvent.Ui.OnBackClicked)
        }
    }

    override fun render(state: DetailState) {
        if (state.isLoading) applyLoadingState()

        state.content?.let {
            applyLoadingState(it)
        }
    }

    private fun applyLoadingState() {
        with(binding) {
            shimmer.show()
            weight.isVisible = false
            height.isVisible = false
            icon.isVisible = false
        }
    }

    private fun applyLoadingState(content: PokemonDetail) {
        with(binding) {
            shimmer.hide()
            weight.apply {
                isVisible = true
                text = String.format(requireContext().getString(R.string.weight), content.weight)
            }
            height.apply {
                isVisible = true
                text = String.format(requireContext().getString(R.string.height), content.height)
            }
            icon.apply {
                isVisible = true
                load(content.iconUrl)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
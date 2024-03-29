package ru.gb.makulin.definitionsfeature.ui.definitions

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.*
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.Lazy
import kotlinx.coroutines.launch
import ru.gb.makulin.core.domainmodel.DataModel
import ru.gb.makulin.core.uistates.DefinitionsScreenUiState
import ru.gb.makulin.core.utils.makeErrSnackbar
import ru.gb.makulin.core.utils.toMainModel
import ru.gb.makulin.definitionsfeature.R
import ru.gb.makulin.definitionsfeature.databinding.FragmentDefinitionsBinding
import ru.gb.makulin.definitionsfeature.di.DefinitionsComponentViewModel
import javax.inject.Inject

class DefinitionsFragment : Fragment(R.layout.fragment_definitions) {

    @Inject
    internal lateinit var definitionsViewModelFactory: Lazy<DefinitionsViewModel.Factory>

    private val binding: FragmentDefinitionsBinding by viewBinding()

    private var adapter: DefinitionsAdapter? = null

    private val definitionsViewModel by viewModels<DefinitionsViewModel> {
        definitionsViewModelFactory.get()
    }

    override fun onAttach(context: Context) {
        ViewModelProvider(this).get<DefinitionsComponentViewModel>()
            .newDefinitionsComponent.inject(this)
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        initViewModel()

    }

    private fun initViewModel() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                definitionsViewModel.uiState.collect { appState ->
                    renderData(appState)
                }
            }
        }
    }

    private fun renderData(appState: DefinitionsScreenUiState) {
        when (appState) {
            is DefinitionsScreenUiState.Error -> {
                binding.root.makeErrSnackbar() {
                    searchData()
                }
            }
            is DefinitionsScreenUiState.Success -> {
                if (appState.dataModel != DataModel(emptyList()) && !appState.dataModel.results[0].word
                        .isNullOrEmpty()
                ) {
                    val mainModel = appState.dataModel.toMainModel()
                    with(binding) {
                        requestedWordTextView.text = mainModel.word
                        transcriptionTextView.text =
                            mainModel.pronunciation?.phoneticSpelling ?: ""
                    }
                    adapter?.submitList(mainModel.senses)
                }
            }
        }
    }

    private fun initViews() {
        setAdapter()
        setOnSearchClickListener()
    }

    private fun setOnSearchClickListener() {
        binding.searchTextInputLayout.setEndIconOnClickListener {
            searchData()
        }
    }

    private fun searchData() {
        val searchText = binding.searchEditText.text.toString()
        if (!searchText.isNullOrEmpty()) {
            definitionsViewModel.fetchData(searchText)
        }
    }

    private fun setAdapter() {
        adapter = DefinitionsAdapter()
        binding.meaningsRecyclerView.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        adapter = null
    }
}
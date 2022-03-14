package com.example.openweatherapiexercise.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.openweatherapiexercise.R
import com.example.openweatherapiexercise.databinding.SearchFragmentBinding
import com.example.openweatherapiexercise.searchresults.SearchResultsFragment

class SearchFragment : Fragment() {

    private val searchViewModel: SearchViewModel by viewModels()

    private var _binding: SearchFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = SearchFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        bindSearchButton()
        observeSearchResult()
        observeSearchError()
    }

    private fun bindSearchButton() = binding.searchButton.setOnClickListener {
        searchViewModel.search(binding.searchEditText.text.toString())
    }

    private fun observeSearchResult() =
        searchViewModel.searchResult.observe(viewLifecycleOwner) {
            it ?: return@observe
            navigateToSearchResults()
        }

    private fun observeSearchError() =
        searchViewModel.searchError.observe(viewLifecycleOwner) {
            it ?: return@observe
            Toast.makeText(context, it, Toast.LENGTH_LONG).show()
        }

    private fun navigateToSearchResults() =
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, SearchResultsFragment())
            .addToBackStack(null)
            .commit()
}

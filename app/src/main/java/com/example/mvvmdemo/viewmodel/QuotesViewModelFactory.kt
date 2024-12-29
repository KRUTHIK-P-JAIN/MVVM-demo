package com.example.mvvmdemo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmdemo.model.QuotesRepository

/**
 * If your ViewModel has dependencies (e.g., a Repository, use case, or any parameters passed to its constructor),
 * you need a factory to properly instantiate it. Without a factory,
 * the default ViewModelProvider won't know how to create your ViewModel.
 */
class QuotesViewModelFactory(private val quotesRepository: QuotesRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return QuotesViewModel(quotesRepository) as T
    }
}
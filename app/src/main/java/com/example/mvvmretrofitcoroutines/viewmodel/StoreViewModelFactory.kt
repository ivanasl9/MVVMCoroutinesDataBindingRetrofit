package com.example.mvvmretrofitcoroutines.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmretrofitcoroutines.repository.RepositoryStore

@Suppress("UNCHECKED_CAST")
class StoreViewModelFactory(private val repositoryStore: RepositoryStore) :ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return StoreViewModel(repositoryStore) as T
    }
}
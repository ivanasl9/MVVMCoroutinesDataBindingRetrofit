package com.example.mvvmretrofitcoroutines.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmretrofitcoroutines.repository.RepositoryStore
import com.example.mvvmretrofitcoroutines.model.StoreItems
import kotlinx.coroutines.Job

class StoreViewModel(private val repositoryStore: RepositoryStore) : ViewModel() {

    private lateinit var job: Job

    private val _store = MutableLiveData<List<StoreItems>>()
    val store: LiveData<List<StoreItems>>
        get() = _store

    fun getStore() {
        job = Coroutines.ioMain(
            { repositoryStore.getStoreItems() },
            { _store.value = it }
        )

    }

    override fun onCleared() {
        super.onCleared()
        if (::job.isInitialized) job.cancel()

    }

}
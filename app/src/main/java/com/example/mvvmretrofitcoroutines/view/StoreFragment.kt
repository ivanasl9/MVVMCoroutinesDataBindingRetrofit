package com.example.mvvmretrofitcoroutines.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmretrofitcoroutines.R
import com.example.mvvmretrofitcoroutines.repository.RepositoryStore
import com.example.mvvmretrofitcoroutines.viewmodel.StoreViewModel
import com.example.mvvmretrofitcoroutines.viewmodel.StoreViewModelFactory
import com.example.mvvmretrofitcoroutines.network.ApiInterface

class StoreFragment : Fragment() {


    private lateinit var factory: StoreViewModelFactory
    private lateinit var viewModel: StoreViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_store, container, false)
        initViewModel()
        return view
    }

    private fun initViewModel() {

        val apiInterface = ApiInterface()
        val repositoryStore = RepositoryStore(apiInterface)
        factory = StoreViewModelFactory(repositoryStore)
        viewModel = ViewModelProvider(this, factory)[StoreViewModel::class.java]
        viewModel.getStore()
        viewModel.store.observe(viewLifecycleOwner, Observer { store ->
            val recycler = view?.findViewById<RecyclerView>(R.id.recView)
            recycler.also {
                if (it != null) {
                    it.layoutManager = LinearLayoutManager(requireContext())
                    it.setHasFixedSize(true)
                    it.adapter = StoreAdapter(store)


                }
            }


        })


    }


}


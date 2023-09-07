package com.example.mvvmretrofitcoroutines.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmretrofitcoroutines.R
import com.example.mvvmretrofitcoroutines.databinding.RowStoreBinding
import com.example.mvvmretrofitcoroutines.model.StoreItems

class StoreAdapter(private val list: List<StoreItems>) :
    RecyclerView.Adapter<StoreAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: RowStoreBinding) : RecyclerView.ViewHolder(binding.root)



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), R.layout.row_store, parent, false
        )
    )

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.store = list[position]
    }


}
package com.example.retrofitsmartheard.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitsmartheard.R
import com.example.retrofitsmartheard.databinding.ItemDestinationBinding
import com.example.retrofitsmartheard.models.Destination

class DestinationAdapter : RecyclerView.Adapter<DestinationAdapter.DestinationViewHolder>() {

    private var destinationList = mutableListOf<Destination>()

    interface EventListener {
        fun onItemClick(position: Int, item: Destination)
    }

    private lateinit var mEventListener: EventListener

    fun setEventListener(eventListener: EventListener) {
        mEventListener = eventListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DestinationViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val itemBinding = DataBindingUtil.inflate<ItemDestinationBinding>(
            inflater,
            R.layout.item_destination,
            parent,
            false
        )
        return DestinationViewHolder(itemBinding)

    }

    override fun onBindViewHolder(holder: DestinationViewHolder, position: Int) {
        val currentItem = destinationList[position]
        try {
            holder.itemBinding.tvDestination.text = currentItem.country
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun getItemCount(): Int = destinationList.size

    fun addAllDestinations(mData: List<Destination>?) {
        destinationList.clear()
        destinationList.addAll(mData!!)
    }

    inner class DestinationViewHolder(internal var itemBinding: ItemDestinationBinding) :
        RecyclerView.ViewHolder(itemBinding.root)

}
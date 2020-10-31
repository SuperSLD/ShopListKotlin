package com.cgroup.shoplistkotlin.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cgroup.shoplistkotlin.R
import com.cgroup.shoplistkotlin.datamodels.ListItems
import com.cgroup.shoplistkotlin.datamodels.Purchase
import java.util.logging.Level
import java.util.logging.Logger

class ListItemsSubAdapter(items : ArrayList<Purchase>) : RecyclerView.Adapter<ListItemsSubAdapter.ItemViewHolder>() {
    private var items = items

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var productName = itemView.findViewById<TextView>(R.id.productName)
        fun bind(item: Purchase) {
            productName.text = item.getName()
        }
    }

    override fun getItemCount(): Int = items.size

    override fun getItemViewType(position: Int): Int = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_shop_list_purchase, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(items[position])
    }
}
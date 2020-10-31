package com.cgroup.shoplistkotlin.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cgroup.shoplistkotlin.R
import com.cgroup.shoplistkotlin.datamodels.Purchase


class CreateListAdapter(items : ArrayList<Purchase>) : RecyclerView.Adapter<CreateListAdapter.ItemViewHolder>() {
    private var items = items

     class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
         private var productName = itemView.findViewById<TextView>(R.id.productName)
         private var buttonDelete = itemView.findViewById<ImageView>(R.id.deleteButton)

         fun bind(item: Purchase, adapter: CreateListAdapter, position: Int, list: ArrayList<Purchase>) {
             productName.text = item.getName()

             buttonDelete.setOnClickListener {
                 list.remove(item)
                 adapter.notifyItemRemoved(position)
             }
         }
    }

    override fun getItemCount(): Int = items.size

    override fun getItemViewType(position: Int): Int = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_create_list, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(items[position], this, position, items)
    }
}
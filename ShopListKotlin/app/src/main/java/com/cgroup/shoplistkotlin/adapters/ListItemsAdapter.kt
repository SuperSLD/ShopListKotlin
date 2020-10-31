package com.cgroup.shoplistkotlin.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cgroup.shoplistkotlin.R
import com.cgroup.shoplistkotlin.adapters.view_holders.AbstractViewHolder
import com.cgroup.shoplistkotlin.data_managers.ShopListManager
import com.cgroup.shoplistkotlin.datamodels.ListItems
import com.cgroup.shoplistkotlin.ui.list.shop_list.ShopListPresenter
import java.util.logging.Level
import java.util.logging.Logger


class ListItemsAdapter(list: ArrayList<ListItems>, presenter: ShopListPresenter) : RecyclerView.Adapter<AbstractViewHolder>() {
    private var list = list
    private var presenter = presenter

    class ListItemViewHolder(itemView: View) : AbstractViewHolder(itemView) {
        private var name = itemView.findViewById<TextView>(R.id.title)
        private var recycler = itemView.findViewById<RecyclerView>(R.id.items)
        private var editButton = itemView.findViewById<ImageView>(R.id.editButton)
        private var deleteButton = itemView.findViewById<ImageView>(R.id.deleteButton)

        fun bind(listItems: ListItems, presenter: ShopListPresenter, adapter: ListItemsAdapter, position: Int) {
            name.text = listItems.getName()

            recycler.layoutManager = LinearLayoutManager(recycler.context)
            recycler.adapter = ListItemsSubAdapter(listItems.getAllList())

            editButton.setOnClickListener {
                presenter.createNewListItem(listItems)
            }
            deleteButton.setOnClickListener {
                presenter.deleteItem(listItems.id)
                adapter.notifyItemRemoved(position)
            }
            Logger.getLogger("shoplog").log(Level.INFO, "bind listitems " + listItems.getName() + " (DELETE THIS LOG)")
        }
    }

    override fun getItemCount(): Int = list.size

    override fun getItemViewType(position: Int): Int = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AbstractViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_shop_list, parent, false)
        return ListItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: AbstractViewHolder, position: Int) {
        if (holder is ListItemViewHolder)
            holder.bind(list[position], presenter, this, position)
    }
}
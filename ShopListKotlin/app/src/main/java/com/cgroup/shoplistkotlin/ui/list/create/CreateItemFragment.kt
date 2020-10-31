package com.cgroup.shoplistkotlin.ui.list.create

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.arellomobile.mvp.presenter.InjectPresenter
import com.cgroup.shoplistkotlin.R
import com.cgroup.shoplistkotlin.adapters.CreateListAdapter
import com.cgroup.shoplistkotlin.datamodels.ListItems
import com.cgroup.shoplistkotlin.datamodels.Purchase
import com.cgroup.shoplistkotlin.extensions.addSystemBottomPadding
import com.cgroup.shoplistkotlin.extensions.addSystemTopPadding
import kotlinx.android.synthetic.main.fragment_create_item.*
import kotlinx.android.synthetic.main.fragment_create_item.container
import pro.midev.gurmanica.common.base.BaseFragment

class CreateItemFragment(items : ListItems?) : BaseFragment(R.layout.fragment_create_item), CreateItemView {
    private var item = items
    private var isNewList = item == null
    private var itemsListClone = arrayListOf<Purchase>()

    @InjectPresenter
    lateinit var presenter : CreateItemPresenter

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        toolbar.addSystemTopPadding()
        container.addSystemBottomPadding()

        if (isNewList) {
            titleToolbar.text = getString(R.string.fragment_create_item)
        } else {
            titleToolbar.text = getString(R.string.fragment_create_item2)

            item?.getAllList()!!.forEach {
                itemsListClone.add(it)
            }

            name.setText(item?.getName())
        }

        itemsList.layoutManager = LinearLayoutManager(context)
        itemsList.adapter = CreateListAdapter(itemsListClone)

        addItem.setOnClickListener {
            if (newItem.text.toString().isNotEmpty()) {
                itemsListClone.add(Purchase(newItem.text.toString()))
                newItem.setText("")
                itemsList.adapter?.notifyItemInserted(itemsListClone.size - 1)
            }
        }

        saveItemButton.setOnClickListener {
            if (itemsListClone.size > 0 && name.text.toString().isNotEmpty())
                if (isNewList) {
                    presenter.addNewItem(name.text.toString(), itemsListClone)
                } else {
                    presenter.rewriteItem(item, name.text.toString(), itemsListClone)
                }
        }

        backButton.setOnClickListener {
            onBackPressed()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        presenter.back()
    }
}
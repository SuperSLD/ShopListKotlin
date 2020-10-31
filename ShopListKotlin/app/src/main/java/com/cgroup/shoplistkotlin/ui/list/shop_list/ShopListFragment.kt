package com.cgroup.shoplistkotlin.ui.list.shop_list

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.arellomobile.mvp.presenter.InjectPresenter
import com.cgroup.shoplistkotlin.R
import com.cgroup.shoplistkotlin.adapters.ListItemsAdapter
import com.cgroup.shoplistkotlin.data_managers.ShopListManager
import com.cgroup.shoplistkotlin.extensions.addSystemBottomPadding
import com.cgroup.shoplistkotlin.extensions.addSystemTopPadding
import kotlinx.android.synthetic.main.fragment_shop_list.*
import org.koin.android.ext.android.inject
import pro.midev.gurmanica.common.base.BaseFragment

class ShopListFragment : BaseFragment(R.layout.fragment_shop_list), ShopView {
    @InjectPresenter
    lateinit var presenter: ShopListPresenter

    private val shopListManager : ShopListManager by inject()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        header.addSystemTopPadding()
        container.addSystemBottomPadding()

        recycler.layoutManager = LinearLayoutManager(context)
        recycler.adapter = ListItemsAdapter(shopListManager.getList(), presenter)

        newList.setOnClickListener {
            presenter.createNewListItem(null)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        presenter.back()
    }
}
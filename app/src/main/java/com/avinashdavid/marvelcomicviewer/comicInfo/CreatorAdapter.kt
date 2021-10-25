package com.avinashdavid.marvelcomicviewer.comicInfo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.avinashdavid.marvelcomicviewer.R
import com.avinashdavid.marvelcomicviewer.api.models.Creator
import com.avinashdavid.marvelcomicviewer.api.models.CreatorSummary
import com.avinashdavid.marvelcomicviewer.util.BaseAdapterDelegate
import com.avinashdavid.marvelcomicviewer.util.BaseAdapterDelegateAdapter
import java.util.*

class CreatorAdapter(activity: FragmentActivity) : BaseAdapterDelegateAdapter(activity, mutableListOf(CreatorAdapterDelegate(activity))) {
}

class CreatorAdapterDelegate(activity: FragmentActivity) : BaseAdapterDelegate(activity) {
    override fun isForViewType(items: List<Any>, position: Int): Boolean {
        return items[position] is CreatorSummary
    }

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return CreatorViewHolder(LayoutInflater.from(activity).inflate(R.layout.item_creator, parent, false))
    }

    override fun onBindViewHolder(
        items: List<Any>,
        position: Int,
        viewHolder: RecyclerView.ViewHolder
    ) {
        val holder = viewHolder as CreatorViewHolder
        val creator = items[position] as CreatorSummary
        holder.apply {
            tvCreator.text = creator.name
            tvCreatorRole.text = creator.role?.capitalize(Locale.getDefault())
        }
    }

    class CreatorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvCreator: TextView = itemView.findViewById(R.id.tvCreator)
        val tvCreatorRole: TextView = itemView.findViewById(R.id.tvCreatorRole)
    }
}
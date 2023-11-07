package com.example.lab1.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.lab1.databinding.ItemViewBinding
import com.example.lab1.diffutil.ItemDiffUtilCallback
import com.example.lab1.models.Item

class ToDoListAdapter: ListAdapter<Item,ToDoListAdapter.ViewHolder>(ItemDiffUtilCallback()) {
    var onItemClicked: ((Item) -> Unit)? = null
    inner class ViewHolder(
        private val binding: ItemViewBinding
    ): RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Item) {
            binding.title.text = item.title
            binding.description.text = item.description
            binding.image.isVisible = item.isDone
            binding.root.setOnClickListener {
                onItemClicked?.invoke(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
package com.example.lab1.diffutil

import androidx.recyclerview.widget.DiffUtil
import com.example.lab1.models.Item

class ItemDiffUtilCallback: DiffUtil.ItemCallback<Item>() {
    override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
        return oldItem == newItem
    }

    override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
        return oldItem == newItem
    }
}
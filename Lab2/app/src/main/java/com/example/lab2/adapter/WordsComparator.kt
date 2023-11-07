package com.example.lab2.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.lab2.entity.Word

class WordsComparator: DiffUtil.ItemCallback<Word>() {
    override fun areContentsTheSame(oldItem: Word, newItem: Word): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areItemsTheSame(oldItem: Word, newItem: Word): Boolean {
        return oldItem == newItem
    }
}
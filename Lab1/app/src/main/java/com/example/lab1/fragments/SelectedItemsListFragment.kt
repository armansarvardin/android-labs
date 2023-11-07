package com.example.lab1.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lab1.adapter.ToDoListAdapter
import com.example.lab1.databinding.SelectedItemsListFragmentBinding
import com.example.lab1.models.Item

class SelectedItemsListFragment(val items: List<Item>): Fragment() {
    private var _binding: SelectedItemsListFragmentBinding? = null
    private var toDoListAdapter: ToDoListAdapter? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = SelectedItemsListFragmentBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toDoListAdapter = ToDoListAdapter()
        binding.selectedItemsList.adapter = toDoListAdapter
        binding.selectedItemsList.layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.VERTICAL,
            false
        )
        toDoListAdapter?.submitList(items)
    }
}
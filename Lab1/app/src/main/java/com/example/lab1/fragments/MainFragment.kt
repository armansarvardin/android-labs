package com.example.lab1.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lab1.R
import com.example.lab1.adapter.ToDoListAdapter
import com.example.lab1.databinding.MainFragmentBinding
import com.example.lab1.models.Item

class MainFragment: Fragment() {
    private var _binding: MainFragmentBinding? = null
    private var toDoListAdapter: ToDoListAdapter? = null
    private var items = listOf(
        Item(title = "Daily planning", description = "Description"),
        Item(title = "Coding", description = "Description"),
        Item(title = "Code review", description = "Do a code review to a group of mobile developers Do a code review to a group of mobile developers")
    )

    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toDoListAdapter = ToDoListAdapter()
        binding.todolist.adapter = toDoListAdapter
        toDoListAdapter?.submitList(items)
        binding.todolist.layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.VERTICAL,
            false
        )
        toDoListAdapter?.onItemClicked = {
            updateItem(it)
        }
        toDoListAdapter?.submitList(items)

        binding.button.setOnClickListener {
            val selectedItemsListFragment = SelectedItemsListFragment(items.filter { it.isDone })
            parentFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container_view, selectedItemsListFragment)
                .addToBackStack(null)
                .commit()
        }
    }

    private fun updateItem(item: Item) {
        val newList = items.map {
            if (it == item) {
                it.copy(
                    isDone = !item.isDone
                )
            } else {
                it
            }
        }
        items = newList

        toDoListAdapter?.submitList(items)
    }
}
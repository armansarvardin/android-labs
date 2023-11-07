package com.example.lab2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.fragment.app.viewModels
import com.example.lab2.adapter.WordListAdapter
import com.example.lab2.application.WordsApplication
import com.example.lab2.databinding.FirstFragmentBinding
import com.example.lab2.entity.Word
import com.example.lab2.viewmodels.WordViewModel
import com.example.lab2.viewmodels.WordViewModelFactory

class FirstFragment: Fragment() {
    private val newWordActivityRequestCode = 1
    private lateinit var binding: FirstFragmentBinding
    private val wordViewModel: WordViewModel by viewModels {
        WordViewModelFactory((requireActivity().application as WordsApplication).repository)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FirstFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = binding.recyclerview
        val adapter = WordListAdapter()
        recyclerView.adapter = adapter
        binding.fab.setOnClickListener {
            val newWordFragment = NewWordFragment()
            newWordFragment.show(childFragmentManager, newWordFragment::class.java.toString())
        }

        wordViewModel.allWords.observe(viewLifecycleOwner) {words ->
            words?.let { adapter.submitList(it) }
        }
        setFragmentResultListener("ok") { requestKey, bundle ->
            wordViewModel.insert(
                Word(10, bundle.getString("bundlekey")!!)
            )
        }
    }
}
package com.example.lab2

import android.content.DialogInterface
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import com.example.lab2.databinding.NewWordFragmentBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class NewWordFragment: BottomSheetDialogFragment() {
    private lateinit var binding: NewWordFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = NewWordFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonSave
            .setOnClickListener {
                if (TextUtils.isEmpty(binding.editWord.text)) {
                    setFragmentResult("canceled", bundleOf())
                } else {
                    val word = binding.editWord.text.toString()
                    setFragmentResult("ok", bundleOf("bundlekey" to word))
                }
                dismiss()
            }
    }

    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)

    }
}
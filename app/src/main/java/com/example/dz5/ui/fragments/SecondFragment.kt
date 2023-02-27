package com.example.dz5.ui.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import com.example.dz5.R
import com.example.dz5.databinding.FragmentSecondBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class SecondFragment : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentSecondBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setList()
    }

    private fun setList() {
        binding.btnCancel.setOnClickListener {
            dismiss()
        }
        val resultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            }
        binding.btnSettings.setOnClickListener {
            resultLauncher.launch(
                Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS).setData(
                    Uri.parse("package:${requireActivity().packageName}"
                    )
                )
            )

            dismiss()
        }
    }
}
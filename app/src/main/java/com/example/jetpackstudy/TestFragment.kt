package com.example.jetpackstudy

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.jetpackstudy.databinding.FragmentTestBinding

class TestFragment : Fragment() {

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: FragmentTestBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_test, container, false)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        //fragment가 activity 내에 존재하므로 activity의 생명주기를 따라간다
        binding.result.text = viewModel.getCountValue().toString()

        binding.plus.setOnClickListener {
            viewModel.plus()
            binding.result.text = viewModel.getCountValue().toString()
        }

        binding.minus.setOnClickListener {
            viewModel.minus()
            binding.result.text = viewModel.getCountValue().toString()
        }

        return binding.root
    }
}
package com.example.jetpackstudy

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation

class BlankFragment1 : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_blank1, container, false)

        //데이터 전송
        val action = BlankFragment1Directions.actionBlankFragment1ToBlankFragment2("abcdef")

        view.findViewById<Button>(R.id.btn1).setOnClickListener {
//            Navigation.findNavController(view).navigate(R.id.action_blankFragment1_to_blankFragment2, bundle)
            Navigation.findNavController(view).navigate(action)
        }

        return view
    }
}
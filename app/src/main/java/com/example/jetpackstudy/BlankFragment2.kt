package com.example.jetpackstudy

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs

class BlankFragment2 : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    //데이터 수신
    val args : BlankFragment2Args by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_blank2, container, false)
        Log.d("SECOND", args.key)

        view.findViewById<Button>(R.id.btn2).setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_blankFragment2_to_blankFragment3)
        }

        return view
        }
}
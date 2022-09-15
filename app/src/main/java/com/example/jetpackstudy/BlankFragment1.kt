package com.example.jetpackstudy

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
// 첫번째 A / 두번째 B
// enterAnim -> A -> B 갈 때 B가 보이는 방식
// exitAnim -> A -> B 갈 때 A가 사라지는 방식
// popEnterAnim -> 뒤로가기 B -> A로 올 때 A가 나타나는 방식
// popExitAnim -> 뒤로가기로 B -> A로 올 때 B가 사라지는 방식
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
        val action = BlankFragment1Directions.actionBlankFragment1ToBlankFragment2("abcdef", "12345")

        view.findViewById<Button>(R.id.btn1).setOnClickListener {
//            Navigation.findNavController(view).navigate(R.id.action_blankFragment1_to_blankFragment2, bundle)
            Navigation.findNavController(view).navigate(action)
        }

        return view
    }
}
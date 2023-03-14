package com.ubaya.adv160419120_week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_game.*

/**
 * A simple [Fragment] subclass.
 * Use the [GameFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GameFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(arguments != null){
            val playerName = GameFragmentArgs.fromBundle(requireArguments()).playerName
            txtPlayer.text = "$playerName's Turn"

        }
        var score = 0
        var number = 1..100
        var number2 = 1..100
        var randomNumber = number.random()
        var randomNumber2 = number2.random()
        txtNo.text = "$randomNumber + $randomNumber2"
        val answer = randomNumber + randomNumber2
        btnAnswer.setOnClickListener {
            if (txtAnswer.text.toString() == answer.toString()){
                score++
                txtSc.text = score.toString()
                txtNo.text = "$randomNumber + $randomNumber2"
            } else {
                val action = GameFragmentDirections.actionResultFragment(score)
                Navigation.findNavController(it).navigate(action)
            }
        }
    }
}
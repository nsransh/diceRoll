package com.example.kotlin_basic.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kotlin_basic.R
import com.example.kotlin_basic.databinding.FragmentDiceRollBinding


class DiceRollFragment : Fragment() {
    private lateinit var binding : FragmentDiceRollBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDiceRollBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            btnRool.setOnClickListener {
                rollDice()
            }
        }
    }

    private fun rollDice() {
        val dice = Dice(6)
        val diceRoll = dice.roll()
        Log.e("diceroll", diceRoll.toString())

        when(diceRoll){
            1 -> binding.ivDice.setImageResource(R.drawable.dice_1)
            2 -> binding.ivDice.setImageResource(R.drawable.dice_2)
            3 -> binding.ivDice.setImageResource(R.drawable.dice_3)
            4 -> binding.ivDice.setImageResource(R.drawable.dice_4)
            5 -> binding.ivDice.setImageResource(R.drawable.dice_5)
            6 -> binding.ivDice.setImageResource(R.drawable.dice_6)
        }
    }


    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DiceRollFragment()
    }
}
class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}
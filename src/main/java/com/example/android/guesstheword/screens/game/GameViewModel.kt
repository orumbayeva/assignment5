package com.example.android.guesstheword.screens.game

import android.media.Image
import android.util.Log
import android.widget.ImageView
import androidx.lifecycle.ViewModel
import com.example.android.guesstheword.R
import kotlin.collections.listOf as listOf

class GameViewModel : ViewModel() {
    // The current word
    var image = 0
    var image_picture = R.drawable.queen
    var score = 0

    data class picture(val imageId: Int)


    // The list of words - the front of the list is the next word to guess
    private lateinit var wordList: MutableList<String>
    private lateinit var imageList: MutableList<Int>


    /**
     * Resets the list of words and randomizes the order
     */
    private fun resetList() {
        imageList = mutableListOf(
            1,
            2,
            3,
            4,
            5,
            6,
            7,
            8,
            9,
            10
        )
        imageList.shuffle()

    }

    init {
        resetList()
        nextWord()
        Log.i("GameViewModel", "GameViewModel created!")
    }

    /**
     * Moves to the next word in the list
     */
    private fun nextWord() {
        if (!imageList.isEmpty()) {
            image = imageList.removeAt(0)
            image_picture = when (image) {
                1 -> R.drawable.queen
                2 -> R.drawable.ball
                3 -> R.drawable.car
                4 -> R.drawable.flower
                5 -> R.drawable.laptop
                6 -> R.drawable.teacher
                7 -> R.drawable.google
                8 -> R.drawable.iphone
                9 -> R.drawable.covid
                10 -> R.drawable.coffee
                else -> {
                    R.drawable.queen
                }
            }
        }
    }

    /** Methods for buttons presses **/
    fun onSkip() {
        score--
        nextWord()
    }

    fun onCorrect() {
        score++
        nextWord()
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("GameViewModel", "GameViewModel destroyed!")
    }
}

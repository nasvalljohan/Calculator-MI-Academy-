package com.jojjnator.kalkylator

import androidx.compose.ui.graphics.Color
import kotlin.random.Random

class RandomGenerator {

    companion object{
        fun getRandomColor(): Color {

            return Color(
                255,
                Random.nextInt(256),
                Random.nextInt(256),
                Random.nextInt(256)
            )
        }
    }
}
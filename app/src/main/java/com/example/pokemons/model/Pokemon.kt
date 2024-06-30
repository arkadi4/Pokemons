package com.example.pokemons.model

import androidx.annotation.DrawableRes

data class Pokemon(
    val id: Int,
    val name: String,
    val type: String,
    val weight: Double,
    val height: Double,
    @DrawableRes val image: Int,
)
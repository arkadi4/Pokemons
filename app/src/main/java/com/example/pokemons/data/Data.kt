package com.example.pokemons.data

import com.example.pokemons.R
import com.example.pokemons.model.Pokemon

object Data {
    val listOfPokemons = listOf(
        Pokemon(0,"ivyzaur", "grass", 50.0, 1.86, R.drawable.ivyzaur_processed),
        Pokemon(1,"bulbazaur", "grass", 60.5, 1.20, R.drawable.bulbasaur_processed),
        Pokemon(2,"venuzaur", "grass", 75.0, 1.50, R.drawable.venuzaur_processed),
        Pokemon(3,"charmander", "grass", 45.0, 1.05, R.drawable.charmander_processed),
    )
}
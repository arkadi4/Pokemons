package com.example.pokemons.data

import com.example.pokemons.R
import com.example.pokemons.model.Pokemon

object Data {
    val listOfPokemons = listOf(
        Pokemon(0,"ivyzaur", "grass", 50.0, 1.86, R.drawable.ivyzaur_2),
        Pokemon(1,"bulbazaur", "grass", 60.5, 1.20, R.drawable.bulbasaur_2),
        Pokemon(2,"venuzaur", "grass", 75.0, 1.50, R.drawable.venuzaur_2),
        Pokemon(3,"charmander", "fire", 45.0, 1.05, R.drawable.charmander_2),
        Pokemon(4,"charizard", "fire", 90.5, 1.70, R.drawable.charizard_2),
        Pokemon(5,"wartortle", "water", 22.5, 1.00, R.drawable.wartortle_2),
    )
}
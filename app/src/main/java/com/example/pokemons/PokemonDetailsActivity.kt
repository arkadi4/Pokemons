package com.example.pokemons

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.pokemons.data.Data
import com.example.pokemons.model.Pokemon
import com.example.pokemons.databinding.PokemonDetailsBinding

class PokemonDetailsActivity : AppCompatActivity() {

    private lateinit var binding: PokemonDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = PokemonDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.navigateBackButton.setOnClickListener {
            this.finish()
        }

        lateinit var pokemon: Pokemon

        val bundle: Bundle? = intent.extras
        bundle?.let {
            val id = it.getInt("id")
            pokemon = Data.listOfPokemons[id]
            binding.apply {
                pokemonNameTextView.text = pokemon.name
                imageView.setImageResource(pokemon.image)
                pokemonTypeTextView.text = pokemon.type
                pokemonWeightTextView.text = pokemon.weight.toString()
                pokemonHeightTextView.text = pokemon.height.toString()
            }
        } ?: run {
            val toast =
                Toast.makeText(applicationContext, "Something went wrong", Toast.LENGTH_SHORT)
            toast.show()
            this.finish()
        }
    }
}
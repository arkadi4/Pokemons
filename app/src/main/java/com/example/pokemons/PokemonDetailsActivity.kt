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

        binding.navigateBackButton.setOnClickListener{
            this.finish()
        }

        lateinit var pokemon: Pokemon

        val bundle: Bundle? = intent.extras
        bundle?.let {
            val id = it.getInt("id")
            when (id) {
                0 -> pokemon = Data.listOfPokemons[0]
                1 -> pokemon = Data.listOfPokemons[1]
                2 -> pokemon = Data.listOfPokemons[2]
                3 -> pokemon = Data.listOfPokemons[3]
            }
            binding.pokemon = pokemon
            binding.imageView.setImageResource(pokemon.image)
        } ?: run {
            val toast = Toast.makeText(applicationContext, "Something went wrong", Toast.LENGTH_SHORT)
            toast.show()
            this.finish()
        }
    }
}
package com.example.pokemons

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.pokemons.data.Data
import com.example.pokemons.databinding.ActivityMainBinding
import com.example.pokemons.databinding.ItemOfRecyclerViewBinding
import com.example.pokemons.model.Pokemon


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    fun onClick(pokemon: Pokemon) {
        val intent = Intent(this, PokemonDetailsActivity::class.java)
        intent.putExtra("id", pokemon.id)
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Data.listOfPokemons.forEach {pokemon ->
            val itemBinding = ItemOfRecyclerViewBinding.inflate(layoutInflater)
            with (itemBinding) {
                imageView.setImageResource(pokemon.image)
                textView.text = pokemon.name
                itemContainer.setOnClickListener{
                    onClick(pokemon)
                }
            }

            binding.linearLayout.addView(itemBinding.itemContainer)
        }
    }
}

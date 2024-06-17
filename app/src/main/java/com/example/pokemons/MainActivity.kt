package com.example.pokemons

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.example.pokemons.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    fun resizeDpToPx (dp: Int): Int {
        return (dp * resources.displayMetrics.density).toInt()
    }

    class Pokemon (
        val id: Int,
        val name: String,

        @DrawableRes val image: Int,
    )

    fun onCardClickHandler(pokemon: Pokemon) {
        val intent = Intent(this, PokemonDetailsActivity::class.java)
        intent.putExtra("id", pokemon.id)
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val pokemonsList: List<Pokemon> = listOf(
            Pokemon(1,"ivycaur", R.drawable.ivyzaur),
            Pokemon(2,"bulbasaur", R.drawable.bulbasaur),
            Pokemon(3,"venuzaur", R.drawable.venuzaur),
            Pokemon(4,"charmander", R.drawable.charmander),
        )

        for (pokemon in pokemonsList) {

            val card: CardView = CardView(this)
            card.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,resizeDpToPx(180))
            card.setOnClickListener { onCardClickHandler(pokemon) }

            val container: LinearLayout = LinearLayout(this)
            container.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
            container.gravity = Gravity.CENTER_HORIZONTAL
            container.setPadding(16,16,16,16)

            val image: ImageView = ImageView(this)
            image.setImageResource(pokemon.image)
            image.layoutParams = ViewGroup.LayoutParams(resizeDpToPx(180),resizeDpToPx(180))


            val text: TextView = TextView(this)
            text.layoutParams = ViewGroup.LayoutParams(resizeDpToPx(180),resizeDpToPx(180))
            text.text = pokemon.name
            text.textSize = 20F
            text.gravity = Gravity.CENTER

            card.addView(container)
            container.addView(image)
            container.addView(text)

            binding.main.addView(card)
        }
    }
}

package com.example.pokemons

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.pokemons.data.Data
import com.example.pokemons.model.Pokemon
import com.example.pokemons.databinding.ActivityMainBinding
import com.google.android.material.card.MaterialCardView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private fun resizeDpToPx (dp: Int): Int {
        return (dp * resources.displayMetrics.density).toInt()
    }

    private fun onCardClickHandler(pokemon: Pokemon) {
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
            val wrapperForCard = FrameLayout(this).apply {
                layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,resizeDpToPx(200))
                setPadding(16,16,16,0)
                setBackgroundColor(Color.parseColor("#6506c4"))
            }

            val card: MaterialCardView = MaterialCardView(this).apply{
                layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT)
                setBackgroundColor(Color.parseColor("#0feb57"))
                setOnClickListener { onCardClickHandler(pokemon) }
            }

            val container: LinearLayout = LinearLayout(this).apply{
                layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
                gravity = Gravity.CENTER_VERTICAL
            }

            val image: ImageView = ImageView(this).apply{
                layoutParams = ViewGroup.LayoutParams(resizeDpToPx(200),ViewGroup.LayoutParams.MATCH_PARENT)
                setImageResource(pokemon.image)
                scaleType = ImageView.ScaleType.FIT_XY
            }

            val text: TextView = TextView(this). apply{
                layoutParams = ViewGroup.LayoutParams(resizeDpToPx(120),ViewGroup.LayoutParams.MATCH_PARENT)
                text = pokemon.name
                textSize = 24F
                gravity = Gravity.CENTER
            }

            binding.main.addView(wrapperForCard)
            wrapperForCard.addView(card)
            card.addView(container)
            container.addView(image)
            container.addView(text)
        }
    }
}

package com.example.pokemons


import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.ButtonBarLayout
import com.example.pokemons.databinding.PokemonDetailsBinding


class PokemonDetailsActivity : AppCompatActivity() {

    private lateinit var binding: PokemonDetailsBinding

    fun resizeDpToPx (dp: Int): Int {
        return (dp * resources.displayMetrics.density).toInt()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = PokemonDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle: Bundle? = intent.extras
        val id = bundle?.getInt("id")

        var image: Int = 0
        var name = ""

        when (id) {
            1 -> {
                image = R.drawable.ivyzaur
                name = "bulbazaur"
            }
        }

        val rootLayout = binding.root

        val imageView = ImageView(this)
        imageView.setImageResource(image)
        imageView.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT )
        val textView = TextView(this)
        textView.text = name
        textView.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, resizeDpToPx(50) )

        rootLayout.addView(imageView)
        rootLayout.addView(textView)


    }
}
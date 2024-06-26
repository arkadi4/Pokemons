package recycler_view

import android.content.Intent
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemons.PokemonDetailsActivity
import com.example.pokemons.databinding.ItemOfRecyclerViewBinding
import com.example.pokemons.model.Pokemon

class RecyclerViewHolder(val binding: ItemOfRecyclerViewBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(pokemon: Pokemon) {
        binding.textView.text = pokemon.name
        binding.imageView.setImageResource(pokemon.image)

        ///  Можно ли в комментариях задавать вопросы?
        ///  Если да, то тожно ли так напрямую во вьюХолдере навесить ОнКлик?
        binding.itemContainer.setOnClickListener{
            val intent: Intent = Intent(it.context, PokemonDetailsActivity::class.java)
            intent.putExtra("id", pokemon.id)
            ContextCompat.startActivity(it.context, intent, null)
        }
    }
}
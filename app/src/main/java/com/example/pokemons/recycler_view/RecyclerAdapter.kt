package com.example.pokemons.recycler_view

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemons.PokemonDetailsActivity
import com.example.pokemons.databinding.ItemOfRecyclerViewBinding
import com.example.pokemons.model.Pokemon

class MyRecyclerAdapter(private var listOfPokemons: List<Pokemon>): RecyclerView.Adapter<RecyclerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val inflater: LayoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemOfRecyclerViewBinding.inflate(inflater, parent, false)
        return RecyclerViewHolder(binding)
    }

    override fun getItemCount(): Int = listOfPokemons.size

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        val pokemon = listOfPokemons[position]
        with (holder.binding) {
            textView.text = pokemon.name
            imageView.setImageResource(pokemon.image)
            itemContainer.setOnClickListener{
                val intent: Intent = Intent(it.context, PokemonDetailsActivity::class.java)
                intent.putExtra("id", pokemon.id)
                startActivity(it.context, intent, null)
            }
        }
    }

    fun setData(newList: List<Pokemon>) {
        val diffUtilCallback = MyDiffUtil(listOfPokemons, newList)
        val diffResults = DiffUtil.calculateDiff(diffUtilCallback)
        listOfPokemons = newList
        diffResults.dispatchUpdatesTo(this)
    }
}
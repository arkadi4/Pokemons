package com.example.pokemons

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.unit.dp
import com.example.pokemons.data.Data
import com.example.pokemons.databinding.ActivityMainBinding
import com.example.pokemons.recycler_view.MyItemDecoration
import com.example.pokemons.recycler_view.MyRecyclerAdapter



class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = MyRecyclerAdapter(Data.listOfPokemons)
        binding.apply {
            recyclerView.adapter = adapter
            recyclerView.addItemDecoration(MyItemDecoration(50.dp))
            button.setOnClickListener{
                val newList = Data.listOfPokemons.shuffled()
                adapter.setData(newList)
            }
        }
    }
}

package com.example.pokemons

import android.os.Bundle
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.unit.dp
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.pokemons.data.Data
import com.example.pokemons.databinding.ActivityMainBinding
import recycler_view.MyItemDecoration
import recycler_view.MyRecyclerAdapter


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dividerItemDecoration = DividerItemDecoration(this, LinearLayout.VERTICAL)

        val adapter = MyRecyclerAdapter(Data.listOfPokemons)
        with (binding) {
            recyclerView.adapter = adapter
            recyclerView.addItemDecoration(MyItemDecoration(50.dp))
            recyclerView.addItemDecoration(dividerItemDecoration)
            button.setOnClickListener{
                val newList = Data.listOfPokemons.shuffled()
                adapter.setData(newList)
            }
        }
    }
}

package com.shubhans.gamingassignment.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.shubhans.gamingassignment.R
import com.shubhans.gamingassignment.repository.CatRepository
import com.shubhans.gamingassignment.ui.adapter.CatAdapter
import com.shubhans.gamingassignment.ui.details.DetailActivity
import com.shubhans.gamingassignment.utils.Resource

class MainActivity : ComponentActivity() {
    private lateinit var viewModel: MainViewModel
    private lateinit var catAdapter: CatAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        progressBar = findViewById(R.id.progressBar)

        // 🛠 IMPORTANT: Set LayoutManager here
        recyclerView.layoutManager = GridLayoutManager(this, 2) // 2 columns

        val repository = CatRepository()
        viewModel =
            ViewModelProvider(this, MainViewModelFactory(repository))[MainViewModel::class.java]

        viewModel.getCats().observe(this) { result ->
            when (result) {
                is Resource.Loading -> {
                    progressBar.visibility = View.VISIBLE
                }

                is Resource.Success -> {
                    progressBar.visibility = View.GONE
                    result.data?.let { cats ->
                        catAdapter = CatAdapter(cats) { cat ->
                            val intent = Intent(this, DetailActivity::class.java)
                            intent.putExtra("image_url", cat.url)
                            intent.putExtra("image_width", cat.width)
                            intent.putExtra("image_height", cat.height)
                            startActivity(intent)

                        }
                        recyclerView.adapter = catAdapter
                    }
                }

                is Resource.Error -> {
                    progressBar.visibility = View.GONE
                    Toast.makeText(this, result.message, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}

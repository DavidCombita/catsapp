package com.davidcombita.views.activity

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.RecyclerView
import com.davidcombita.R
import com.davidcombita.viewmodels.MainViewModel
import com.davidcombita.views.adapters.CatsAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val progress = findViewById<ProgressBar>(R.id.progressBar)
        val recycler = findViewById<RecyclerView>(R.id.recyclerView)
        val adapter = CatsAdapter()
        recycler.adapter = adapter

        lifecycleScope.launch{
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.cats.collect{ info ->
                    if(info.error){
                        Toast.makeText(this@MainActivity,
                            "Error al traer la información", Toast.LENGTH_LONG).show()
                    }else{
                        progress.visibility = if (info.loading) View.VISIBLE else View.GONE
                        adapter.setList(info.catsInfo)
                    }
                }
            }
        }
    }
}
package com.example.apiapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apiapp.databinding.ActivityMainBinding
import com.example.apiapp.network.ApiClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding as ActivityMainBinding

    private var _viewModel: MainViewModel? = null
    private val viewModel get() = _viewModel as MainViewModel

    private var listCat = ArrayList<DataResponseItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        _viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.button.setOnClickListener {
            binding.button.animate().apply {
                rotationBy(360f)
                duration = 1000
            }.start()

            viewModel.apply {
                getDataCat()
                dataResponse.observe(this@MainActivity) {showData(it as ArrayList<DataResponseItem>)}
                isError.observe(this@MainActivity) {showError(it)}
            }
        }
    }

    private fun showError(error: Throwable?) {
        Log.e("CatFragment", "showError: $error")
    }

    private fun showData(data: ArrayList<DataResponseItem>) {
        binding.rvCat.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = CatAdapter(data)
        }
    }
}


package com.birdushenin.yandexservices.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.birdushenin.yandexservices.R
import com.birdushenin.yandexservices.databinding.FragmentAddBinding
import com.birdushenin.yandexservices.domain.NewsService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Add : Fragment() {

    // Экземпляр адаптера
    private val adapter = NewsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentAddBinding.inflate(layoutInflater)
        val retrofit = Retrofit.Builder()
            .baseUrl("https://newsapi.org/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val newsService = retrofit.create(NewsService::class.java)

        //RecyclerView
        val recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter

        binding.progressBar.visibility = View.VISIBLE

        // Улучшить потом вызывов loadNews() внутри корутины
        lifecycleScope.launch {
            loadNews(newsService)
            binding.progressBar.visibility = View.GONE
        }

        return binding.root
    }

    private suspend fun loadNews(newsService: NewsService) {
        val apiKey = "eae4e313c2d043c183e78149bc172501"

        try {
            val response = newsService.getTopHeadlines(apiKey = apiKey)
            if (response.isSuccessful) {
                val newsList = response.body()?.articles ?: emptyList()
                withContext(Dispatchers.Main) {
                    adapter.submitList(newsList)
                }
            }
        } catch (e: Exception) {
            // Ошибки если вдруг
        }
    }
}
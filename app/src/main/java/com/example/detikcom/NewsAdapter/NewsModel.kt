package com.example.detikcom.NewsAdapter

import com.example.detikcom.R

data class news (var title: String,var desc: String,var detail: String,var photo: Int)

object NewsModel {
    val newsList = listOf<news>(
        news(
            "contoh 1",
            "Detikcom | 1 jam yang lalu",
            "ini adalah hasil detail",
            R.drawable.img_news1
        ),
        news(
            "contoh 2",
            "Detikcom | 1 jam yang lalu",
            "ini adalah hasil detail 2",
            R.drawable.img_news2
        ),
        news(
            "contoh 3",
            "Detikcom | 1 jam yang lalu",
            "ini adalah hasil detail 3",
            R.drawable.img_news3
        ),
        news(
            "contoh 4",
            "Detikcom | 1 jam yang lalu",
            "ini adalah contoh 4",
            R.drawable.img_news4
        )
    )
}
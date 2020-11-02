package com.example.detikcom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.detikcom.NewsAdapter.NewsAdapter
import com.example.detikcom.NewsAdapter.NewsModel
import com.example.detikcom.NewsAdapter.news
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.lay_berita.*

class MainActivity : AppCompatActivity() {

    private lateinit var newsAdapter: NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //region headline

        var headlinenews: news?
        if(NewsModel.newsList.size>0){
            headlinenews = NewsModel.newsList[NewsModel.newsList.size-1]
            tvw_TitleHeadline.setText(headlinenews.title)
            tvw_DescHeadline.setText(headlinenews.desc)
            img_news0.setImageResource(headlinenews.photo)

            cdv_newsheadline.setOnClickListener {
                val intent_detail = Intent(this, DetailActiviy::class.java)
                    .apply {
                        putExtra(DetailActiviy.cont_TitleNews, headlinenews.title)
                        putExtra(DetailActiviy.cont_PhotoNews, headlinenews.photo.toString())
                    }
                startActivity(intent_detail)
                finish()
            }
        }

        //endregion

        val layManager = LinearLayoutManager(this)
        layManager.orientation = LinearLayoutManager.VERTICAL
        rcv_daftarberita.layoutManager = layManager

        newsAdapter = NewsAdapter(this,NewsModel.newsList)
        rcv_daftarberita.adapter = newsAdapter

        newsAdapter.setOnClickCallback(object : NewsAdapter.OnItemClickCallback{
            override fun OnItemClick(data: news) {
                val intent = Intent(this@MainActivity,DetailActiviy::class.java)
                    .apply {
                        putExtra(DetailActiviy.cont_TitleNews, data.title.toString())
                        putExtra(DetailActiviy.cont_kontenNews, data.detail.toString())
                        putExtra(DetailActiviy.cont_PhotoNews, data.photo.toString())
                    }

                startActivity(intent)
                finish()
            }
        })
    }
}
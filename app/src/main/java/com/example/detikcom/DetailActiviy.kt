package com.example.detikcom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.detikcom.R
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActiviy : AppCompatActivity() {
    companion object{
        const val cont_TitleNews = "cont_TitleNews"
        const val cont_PhotoNews = "cont_PhotoNews"
        const val cont_kontenNews= "cont_KontentNews"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        txt_TitleNews.setText(intent.getStringExtra(cont_TitleNews))
        img_toolbar.setImageResource(intent.getStringExtra(cont_PhotoNews)!!.toInt())
        txt_kontenNews.setText(intent.getStringExtra(cont_kontenNews))

        btn_back.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                    val intentMain = Intent(this@DetailActiviy,MainActivity::class.java)

                    startActivity(intentMain)
                    finish()
                }
        })
    }
}
package com.example.simplejsonparser

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.simplejsonparser.repository.Repository

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel : MainViewModel

    private lateinit var userId : TextView
    private lateinit var id : TextView
    private lateinit var title : TextView
    private lateinit var body : TextView

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)

        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getPost()

        viewModel.myResponse.observe(this, Observer { response ->
            userId = findViewById(R.id.user_id)
            id = findViewById(R.id.id)
            title = findViewById(R.id.tv_title)
            body = findViewById(R.id.body)

            userId.text = "UserId: ${response.userId.toString()}"
            id.text = "Id: ${response.id.toString()}"
            title.text = "Title: ${response.title.toString()}"
            body.text = "Body: ${response.body.toString()}"
        })

    }
}
package com.example.apiapp050520

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_joke.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.time.measureTimedValue

class JokeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_joke)

        btnJoke.setOnClickListener {
            LoadJoke()
        }
        btnJoke2.setOnClickListener {
            loadJoke2()
        }
    }

    fun loadJoke2() {


        val retrofit = Retrofit.Builder()
            .baseUrl("https://icanhazdadjoke.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val jokeservice2: JokeService
        jokeservice2 = retrofit.create(JokeService::class.java)

        val request = jokeservice2.getJoke2()

        request.enqueue(object : Callback<Joke2>{
            override fun onFailure(call: Call<Joke2>, t: Throwable) {
                Log.d("JokeActivity",t.toString())
            }

            override fun onResponse(call: Call<Joke2>, response: Response<Joke2>) {
                if (response.isSuccessful){
                    tvJoke2.text = response.body()!!.joke

                }
            }

        })
    }

    fun LoadJoke() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://geek-jokes.sameerkumar.website")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val jokeservice: JokeService
        jokeservice = retrofit.create(JokeService::class.java)

        val request = jokeservice.getJoke("json")

        request.enqueue(object : Callback<Joke>{
            override fun onFailure(call: Call<Joke>, t: Throwable) {
                Log.d("JokeActivity",t.toString())
            }

            override fun onResponse(call: Call<Joke>, response: Response<Joke>) {
                if (response.isSuccessful){
                    tvJoke.text = response.body()!!.joke

                }
            }
        })
    }

}

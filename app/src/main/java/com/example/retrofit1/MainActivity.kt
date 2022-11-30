package com.example.retrofit1

import android.annotation.SuppressLint
import android.app.ProgressDialog.show
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofit1.Adapter.MyMovieAdapter
import com.example.retrofit1.Common.Common
import com.example.retrofit1.Interface.RetrofitService
import com.example.retrofit1.Model.Movie
import com.example.retrofit1.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response




class MainActivity : AppCompatActivity() {
    lateinit var mService: RetrofitService
    lateinit var layoutManager: LinearLayoutManager
    lateinit var  adapter: MyMovieAdapter
    lateinit var dialog: AlertDialog
    private  lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mService = Common.retrofitService
        recyclerMovieList.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this)
        recyclerMovieList.layoutManager = layoutManager
        //dialog = SpotsDialog.Builder().setCancelable(true).setContext(this).build()

        getAllMovieList()
    }
    private  fun getAllMovieList() {
        //dialog.show()


        mService.getMovieList().enqueue(object : Callback<MutableList<Movie>> {
            override fun onFailure(call: Call<MutableList<Movie>>, t: Throwable) {

            }
            @SuppressLint("NotifyDataSetChanged")
            override  fun onResponse(
                call: Call<MutableList<Movie>>, response: Response<MutableList<Movie>>){
                adapter = MyMovieAdapter(baseContext, response.body() as MutableList<Movie>)
                adapter.notifyDataSetChanged()
                recyclerMovieList.adapter = adapter
               // dialog.dismiss()

            }
        })
    }
}






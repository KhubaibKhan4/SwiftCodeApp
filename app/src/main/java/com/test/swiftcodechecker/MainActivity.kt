package com.test.swiftcodechecker

import android.annotation.SuppressLint
import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.SearchView

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.test.swiftcodechecker.adapter.MyAdapter
import com.test.swiftcodechecker.repository.Repository

class MainActivity : AppCompatActivity() {
    lateinit var mainViewModel: MainViewModel
    lateinit var recyclerView: RecyclerView
    private val myAdapter by lazy { MyAdapter() }
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setRecyclerView()

        val progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Please Be Patient")
        progressDialog.setMessage("Please Wait, We are fetching data from The Server. it will take few minutes to load...")
        progressDialog.setCancelable(false)
        progressDialog.show()

        val repository = Repository()
        val mainViewModelFactory = MainViewModelFactory(repository)
        mainViewModel = ViewModelProvider(this, mainViewModelFactory).get(MainViewModel::class.java)

        val searchView = findViewById<SearchView>(R.id.searchView)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                mainViewModel.getSwiftCode(query.toString())
                mainViewModel.myResponse.observe(this@MainActivity, Observer { response ->

                    if (response.isSuccessful) {
                        progressDialog.dismiss()
                        response.body()?.let { myAdapter.setData(it) }
                    } else {
                        progressDialog.dismiss()
                        Toast.makeText(
                            this@MainActivity,
                            response.errorBody().toString(),
                            Toast.LENGTH_LONG
                        ).show()
                    }
                })
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

        })


        mainViewModel.getSwiftCode("Habib Bank Limited")
        mainViewModel.myResponse.observe(this, Observer { response ->

            if (response.isSuccessful) {
                progressDialog.dismiss()
                response.body()?.let { myAdapter.setData(it) }
            } else {
                progressDialog.dismiss()
                Toast.makeText(
                    this@MainActivity,
                    response.errorBody().toString(),
                    Toast.LENGTH_LONG
                ).show()
            }
        })
    }

    fun setRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_View)
        recyclerView.adapter = myAdapter
        recyclerView.layoutManager = GridLayoutManager(this,2)
    }
}
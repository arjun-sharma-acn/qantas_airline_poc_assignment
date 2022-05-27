package com.example.qantas_airline_poc_assignment.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.qantas_airline_poc_assignment.R
import com.example.qantas_airline_poc_assignment.adapter.AirportListAdapter
import com.example.qantas_airline_poc_assignment.adapter.ItemClickListener
import com.example.qantas_airline_poc_assignment.models.AirportDataClassItem
import com.example.qantas_airline_poc_assignment.repository.Repository
import com.example.qantas_airline_poc_assignment.viewmodel.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ItemClickListener {
    lateinit var recyclerViewAdapter : AirportListAdapter
    val repository: Repository = Repository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.title = "Airport List";
        supportActionBar?.setBackgroundDrawable(ColorDrawable(ContextCompat.getColor(this, R.color.teal_200)))

        progress.visibility = View.VISIBLE
        initRecyclerView()
        initViewModel()

    }

    private fun initRecyclerView() {
        airportListRecyclerView.layoutManager = LinearLayoutManager(this)
        recyclerViewAdapter = AirportListAdapter(this)
        airportListRecyclerView.adapter = recyclerViewAdapter

    }

    @SuppressLint("NotifyDataSetChanged")
    private fun initViewModel(){
        val viewModel: MainActivityViewModel = ViewModelProvider(this,).get(MainActivityViewModel::class.java)
        viewModel.getLiveDataObserver().observe(this) {
            if (it != null) {
                progress.visibility = View.GONE
                recyclerViewAdapter.setAirportList(it)
            } else {
                Toast.makeText(this@MainActivity, "Error in getting list", Toast.LENGTH_LONG).show()
            }
        }
        viewModel.makeRepoCall()
    }


    override fun onItemClickListener(position: Int, airportDataClassItem: AirportDataClassItem) {
        val intent = Intent(applicationContext, DetailsActivity::class.java)
        intent.putExtra("airport_details", airportDataClassItem)
        startActivity(intent)
        //Log.i("item details", airportDataClassItem.airportCode )
    }

}
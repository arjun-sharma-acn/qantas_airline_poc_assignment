package com.example.qantas_airline_poc_assignment.adapter

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.qantas_airline_poc_assignment.R
import com.example.qantas_airline_poc_assignment.models.AirportDataClassItem
import com.example.qantas_airline_poc_assignment.models.AirportModel
import kotlinx.android.synthetic.main.airport_list_row.view.*

class AirportListAdapter(private val mListener: ItemClickListener) :RecyclerView.Adapter<AirportListAdapter.MyViewHolder>()  {

    private var airportList: List<AirportDataClassItem>? = null

    fun setAirportList(airportList: List<AirportDataClassItem>){
        this.airportList = airportList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AirportListAdapter.MyViewHolder {
        val view  = LayoutInflater.from(parent.context).inflate(R.layout.airport_list_row,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: AirportListAdapter.MyViewHolder, position: Int) {
        holder.bind(airportList?.get(position)!!)

        holder.itemView.setOnClickListener {
            mListener.onItemClickListener(position, airportList?.get(position)!!)
        }
        if (position % 2 == 0) {
            holder.itemView.setBackgroundColor(Color.parseColor("#FF03DAC5"))
        } else {
            holder.itemView.setBackgroundColor(Color.parseColor("#FF018786"))
        }
    }

    override fun getItemCount(): Int {
        if(airportList == null) return 0
        else return airportList!!.size
    }

    class MyViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        val tvAirportName = view.tv_AirportName
        val tvCityName = view.tv_CityName


        fun bind(airportModel: AirportDataClassItem) {
            tvAirportName.text = airportModel.airportName
            tvCityName.text = airportModel.airportCode
        }
    }
}
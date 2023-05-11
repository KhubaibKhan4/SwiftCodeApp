package com.test.swiftcodechecker.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.test.swiftcodechecker.R
import com.test.swiftcodechecker.model.SwiftCodeResponseItem


class MyAdapter : RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    private var myList = emptyList<SwiftCodeResponseItem>()

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val bankName: TextView = itemView.findViewById<TextView>(R.id.tvBankName)
        val city: TextView = itemView.findViewById<TextView>(R.id.tvCity)
        val country: TextView = itemView.findViewById<TextView>(R.id.tvCountry)
        val country_code: TextView = itemView.findViewById<TextView>(R.id.tvCountryCode)
        val swift_code: TextView = itemView.findViewById<TextView>(R.id.tvSwiftCode)
        val branch: TextView = itemView.findViewById<TextView>(R.id.tvBranch)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.bank_layout, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return myList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bankName.text = myList[position].bank_name
        holder.city.text = myList[position].city
        holder.country.text = myList[position].country
        holder.country_code.text = myList[position].country_code
        holder.swift_code.text = myList[position].swift_code
        holder.branch.text = myList[position].branch
    }

    fun setData(newList: List<SwiftCodeResponseItem>) {
        myList = newList
        notifyDataSetChanged()
    }
}
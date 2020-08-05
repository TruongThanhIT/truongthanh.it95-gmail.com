package com.thanht.foodyentrytask.home.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.thanht.foodyentrytask.R

class CityListAdapter : RecyclerView.Adapter<CityListHolder>() {
    private val dataList = mutableListOf<CityInfo>()

    fun setData(data: List<CityInfo>) {
        dataList.apply {
            clear()
            addAll(data)
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityListHolder {
        return CityListHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_city, parent, false)
        )
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: CityListHolder, position: Int) {
        holder.bindData(dataList[position])
    }

}
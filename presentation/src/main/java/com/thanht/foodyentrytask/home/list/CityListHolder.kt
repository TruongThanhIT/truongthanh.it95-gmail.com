package com.thanht.foodyentrytask.home.list

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.thanht.foodyentrytask.R

class CityListHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val cityName = itemView.findViewById<TextView>(R.id.tv_city_name)

    fun bindData(cityInfo: CityInfo) {
        cityName.text = cityInfo.name
    }
}
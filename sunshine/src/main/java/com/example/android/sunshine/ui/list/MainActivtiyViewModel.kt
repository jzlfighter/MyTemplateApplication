package com.example.android.sunshine.ui.list

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.example.android.sunshine.data.SunshineRepository
import com.example.android.sunshine.data.database.WeatherEntry
import java.util.*

/**
 * Created by Administrator on 2018/2/28.
 */
class MainActivtiyViewModel(private val mRepository:SunshineRepository):ViewModel(){
    val weather:LiveData<List<WeatherEntry>>
    init {
        weather=mRepository.weather
    }
}
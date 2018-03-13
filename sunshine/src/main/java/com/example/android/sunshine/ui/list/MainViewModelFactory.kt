package com.example.android.sunshine.ui.list

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.android.sunshine.data.SunshineRepository
import java.util.*

@Suppress("UNCHECKED_CAST")
/**
 * Created by Administrator on 2018/2/28.
 */
class MainViewModelFactory(val mRepository: SunshineRepository):ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>?): T {
        return MainActivtiyViewModel(mRepository) as T
    }
}
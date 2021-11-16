package com.avanade.popfunko.datasource

import android.content.Context
import com.avanade.popfunko.R

class CollectionsDataSource(private val context : Context) {
    fun getData() : List<String>{
        return context.resources.getStringArray(R.array.Collections).toList()
    }
}
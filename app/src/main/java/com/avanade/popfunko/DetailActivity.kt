package com.avanade.popfunko

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.avanade.popfunko.adapter.FunkoAdapter
import com.avanade.popfunko.datasource.FunkoDataSource

class DetailActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView

    companion object{
        const val COLLECTION = "COLLECTION"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val collection = intent?.extras?.getString(COLLECTION).toString()

        recyclerView = findViewById(R.id.recyclerViewFunkos)
        var data = FunkoDataSource(resources.getXml(R.xml.funko)).getData(collection)
        recyclerView.adapter = FunkoAdapter(this, data)
        recyclerView.setHasFixedSize(true)
    }
}
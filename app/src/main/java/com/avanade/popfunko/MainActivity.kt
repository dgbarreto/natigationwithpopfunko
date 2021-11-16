package com.avanade.popfunko

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.avanade.popfunko.adapter.CollectionAdapter
import com.avanade.popfunko.datasource.CollectionsDataSource

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var data: List<String>
    private var isLinearLayout = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerCollections)
        data = CollectionsDataSource(this).getData()
        setLayout()
    }

    private fun setLayout(){
        recyclerView.layoutManager = if(isLinearLayout) LinearLayoutManager(this)
            else GridLayoutManager(this, 4)

        recyclerView.adapter = CollectionAdapter(this, data)
    }

    private fun setIcon(menuItem: MenuItem?){
        if(menuItem == null)
            return

        menuItem.icon = if(isLinearLayout) ContextCompat.getDrawable(this, R.drawable.ic_grid_layout)
            else ContextCompat.getDrawable(this, R.drawable.ic_linear_layout)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.layout_menu, menu)

        val layoutButton = menu?.findItem(R.id.action_switch_layout)
        setIcon(layoutButton)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.action_switch_layout -> {
                isLinearLayout = !isLinearLayout
                setLayout()
                setIcon(item)
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
package com.example.user_register

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import com.example.user_register.model.ManagerBd

class ControladoresActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_controladores)

        val listUsers = findViewById<ListView>(R.id.listUsers)

        val managerBd = ManagerBd(this)
        val dataUsers = managerBd.listData()

        val adapterUser = ArrayAdapter(this, android.R.layout.simple_list_item_1, dataUsers)
        listUsers.adapter = adapterUser

        listUsers.setOnItemClickListener {parent, view, position, id ->
            Toast.makeText(this, "dataUsers" + parent.getItemAtPosition(position), Toast.LENGTH_SHORT).show()
        }
    }
}
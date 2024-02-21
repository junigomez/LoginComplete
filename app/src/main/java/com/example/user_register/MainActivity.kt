package com.example.user_register

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.user_register.model.ManagerBd

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editnombre = findViewById<EditText>(R.id.editNombre)
        val editapellido = findViewById<EditText>(R.id.editApellido)
        val edittelefono = findViewById<EditText>(R.id.editTelefono)
        val editcedula = findViewById<EditText>(R.id.editCedula)
        val editcontrasena = findViewById<EditText>(R.id.editContrasena)
        val editusuario = findViewById<EditText>(R.id.editUsuario)
        val btnregistrar = findViewById<Button>(R.id.button_Registro)

        btnregistrar.setOnClickListener {
            val nombre = editnombre.text.toString()
            val apellido = editapellido.text.toString()
            val telefono = edittelefono.text.toString()
            val cedula = editcedula.text.toString()
            val contrasena = editcontrasena.text.toString()
            val usuario = editusuario.text.toString()

            val managerBd = ManagerBd(this)
            val resul =
                managerBd.insertDataUser(nombre, apellido, telefono, cedula, contrasena, usuario)
            if (resul > 0 ){
                Toast.makeText(this, "DATOS INSERTADOS CORRECTAMENTE" + resul, Toast.LENGTH_SHORT).show()

            }else{
                Toast.makeText(this, "ERROR AL RECIBIR LOS DATOS" + resul, Toast.LENGTH_SHORT).show()
            }

        }


    }
}
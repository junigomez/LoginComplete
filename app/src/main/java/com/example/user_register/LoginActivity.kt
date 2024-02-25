package com.example.user_register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.user_register.model.ManagerBd


class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        val registro = findViewById<Button>(R.id.buttonRegistrarseLogin)
        val ingresar = findViewById<Button>(R.id.buttonIngresarLogin)
        val user= findViewById<EditText>(R.id.User)
        val password= findViewById<EditText>(R.id.Password)

        val managerBd = ManagerBd(this)

        ingresar.setOnClickListener {
            val username = user.text.toString()
            val password = password.text.toString()

            if (username.isNotEmpty() && password.isNotEmpty()) {
                // Verificar inicio de sesión
                val login = managerBd.login(username, password)

                if (login) {
                    // Inicio de sesión exitoso
                    Toast.makeText(this, "Login Succesfully", Toast.LENGTH_SHORT).show()
                } else {
                    // Inicio de sesión fallido, mostrar mensaje de error
                    Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show()
                }
            } else {
                // Campos de nombre de usuario o contraseña vacíos, mostrar mensaje de error
                Toast.makeText(this, "Please enter user and password", Toast.LENGTH_SHORT).show()
            }
        }

        registro.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }

    }
}
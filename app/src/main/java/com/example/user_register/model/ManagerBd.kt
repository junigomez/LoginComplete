package com.example.user_register.model

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase

class ManagerBd (val context: Context){
    lateinit var bd: SQLiteDatabase
    val helperbd = HelperBd(context)

    fun openBDWr(){
        bd = helperbd.writableDatabase
    }

    fun openBdRd(){
        bd = helperbd.readableDatabase
    }
    @SuppressLint("SuspiciousIdentation")
    fun insertDataUser(nombre: String, apellido: String, telefono: String, cedula: String, contrasena: String, usuario: String): Long{
        openBDWr()

        val values = ContentValues()
        values.put("nombre", nombre)
        values.put("apellido", apellido)
        values.put("telefono", telefono)
        values.put("cedula", cedula)
        values.put("contrasena", contrasena)
        values.put("usuario", usuario)

        val resul = bd.insert("register_user", null, values)
        return resul
    }
    fun listData():ArrayList<Usuario>{
        val userList = ArrayList<Usuario>()
        openBdRd()

        val cursor: Cursor = bd.rawQuery("SELECT * FROM register_user", null)
        if (cursor.moveToFirst()){

            do {
                val nombreIndex = cursor.getColumnIndex("nombre")
                val apellidoIndex = cursor.getColumnIndex("apellido")
                val telefonoIndex = cursor.getColumnIndex("telefono")
                val cedulaIndex = cursor.getColumnIndex("cedula")
                val contrasenaIndex = cursor.getColumnIndex("contrasena")
                val usuarioIndex = cursor.getColumnIndex("usuario")

                val nombre = cursor.getString(nombreIndex)
                val apellido = cursor.getString(apellidoIndex)
                val telefono = cursor.getString(telefonoIndex)
                val cedula = cursor.getString(cedulaIndex)
                val contrasena = cursor.getString(contrasenaIndex)
                val usuario = cursor.getString(usuarioIndex)

                val usuarioData = Usuario(nombre, apellido, telefono, cedula, contrasena, usuario)
                userList.add(usuarioData)

            }while (cursor.moveToNext())

        }
        return userList
    }
    fun login(usuario: String, contrasena: String): Boolean{
        openBdRd()

        val cursor: Cursor = bd.rawQuery("SELECT * FROM register_user WHERE usuario = ? AND contrasena = ?",
            arrayOf(usuario, contrasena)
        )
        val result = cursor.count >0
        cursor.close()
        return result
    }
}
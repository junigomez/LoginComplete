package com.example.user_register.model

class Constantes {
    companion object{
        const val NAME_BD = "BDUser_Register"
        const val VERSION_BD = 3

        const val TABLA = "create table register_user(nombre text, apellido text, telefono text, cedula text, contrasena text, usuario text)"
        const val LOGIN = "Select usuario, contrasena from register_user"
    }
}
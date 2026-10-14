package com.example.practica2

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate

class MainActivity : AppCompatActivity() {

    // ZONA 1: Variables de la clase
    private lateinit var tvMensaje: TextView
    private lateinit var etxtNombre: EditText
    private lateinit var etxtMatricula: EditText
    private lateinit var btnRegistrar: Button
    private lateinit var btnLimpiar: Button
    private lateinit var btnTemaRMR: Button
    private lateinit var pbCarga: ProgressBar

    private var contadorAsistentes = 0
    private var oscuroRMR = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // ZONA 2: Enlace de vistas mediante findViewById
        tvMensaje = findViewById(R.id.tvMensaje)
        etxtNombre = findViewById(R.id.etxtNombre)
        etxtMatricula = findViewById(R.id.etxtMatricula)
        btnRegistrar = findViewById(R.id.btnRegistrar)
        btnLimpiar = findViewById(R.id.btnLimpiar)
        btnTemaRMR = findViewById(R.id.btnTema)
        pbCarga = findViewById(R.id.pbCarga)

        btnRegistrar.setOnClickListener {
            registrar()
        }

        btnLimpiar.setOnClickListener {
            limpiar()
        }

        btnTemaRMR.setOnClickListener {
            cambiarTemaRMR()
        }
    }

    // ZONA 3: Funciones de la aplicacion

    private fun registrar() {
        val nombre = etxtNombre.text.toString().trim()
        val matricula = etxtMatricula.text.toString().trim()

        // Validaciones usando recursos de strings.xml
        if (nombre.isEmpty()) {
            Toast.makeText(this, getString(R.string.val_nombre_vacioRMR), Toast.LENGTH_SHORT).show()
            return
        }
        if (nombre.length < 3) {
            Toast.makeText(this, getString(R.string.val_nombre_cortoRMR), Toast.LENGTH_SHORT).show()
            return
        }
        if (matricula.isEmpty()) {
            Toast.makeText(this, getString(R.string.val_matricula_vaciaRMR), Toast.LENGTH_SHORT).show()
            return
        }
        if (matricula.length != 7) {
            Toast.makeText(this, getString(R.string.val_matricula_largoRMR), Toast.LENGTH_SHORT).show()
            return
        }

        // Proceso antes de la carga
        contadorAsistentes++
        pbCarga.visibility = View.VISIBLE
        tvMensaje.text = ""
        btnRegistrar.isEnabled = false
        btnLimpiar.isEnabled = false

        // Simulacion de respuesta (1.5s)
        Handler(Looper.getMainLooper()).postDelayed({
            pbCarga.visibility = View.GONE

            // Mensaje usando marcadores de posicion (%1$s, %2$s, %3$d)
            tvMensaje.text = getString(R.string.msg_registradoRMR, nombre, matricula, contadorAsistentes)

            btnRegistrar.isEnabled = true
            btnLimpiar.isEnabled = true
            btnRegistrar.text = getString(R.string.btn_registrar_otroRMR)
        }, 1500)
    }

    private fun limpiar() {
        etxtNombre.setText("")
        etxtMatricula.setText("")
        pbCarga.visibility = View.GONE
        tvMensaje.text = getString(R.string.msg_inicialRMR)
        btnRegistrar.text = getString(R.string.btn_registrarRMR)
        btnRegistrar.isEnabled = true
        btnLimpiar.isEnabled = true
        etxtNombre.requestFocus()
    }

    private fun cambiarTemaRMR() {
        oscuroRMR = !oscuroRMR

        if (oscuroRMR) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            btnTemaRMR.text = getString(R.string.btn_tema_claroRMR)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            btnTemaRMR.text = getString(R.string.btn_tema_oscuroRMR)
        }
    }
}
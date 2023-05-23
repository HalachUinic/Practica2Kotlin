package com.example.practica02kotlintarea

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.text.DecimalFormat
class MainActivity : AppCompatActivity() {

    private lateinit var txtaltura: EditText
    private lateinit var txtpeso: EditText
    private lateinit var txtIMC: EditText
    private lateinit var btnCalcular: Button
    private lateinit var btnBorrar: Button
    private lateinit var btnCerrar: Button

//
    private var altura = 0.0
    private var peso = 0.0
    private var imc = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtaltura = findViewById(R.id.txtaltura)
        txtpeso = findViewById(R.id.txtpeso)
        txtIMC = findViewById(R.id.txtimc)
        btnCalcular = findViewById(R.id.btnCalcular)
        btnCerrar = findViewById(R.id.btnCerrar)
        btnBorrar = findViewById(R.id.btnBorrar)

        btnBorrar.setOnClickListener {
            txtpeso.text.clear()
            txtIMC.text.clear()
            txtaltura.text.clear()
        }

        btnCalcular.setOnClickListener {
            if (txtaltura.text.toString().isEmpty() || txtpeso.text.toString().isEmpty()) {
                Toast.makeText(this@MainActivity, "Llene todos los campos", Toast.LENGTH_SHORT).show()
            } else {
                altura = txtaltura.text.toString().toDouble()
                peso = txtpeso.text.toString().toDouble()
                altura /= 100
                val format = DecimalFormat("#.##")
                imc = peso / (altura * altura)
                txtIMC.setText(format.format(imc))
            }
        }

        btnCerrar.setOnClickListener {
            finish()
        }
    }
}

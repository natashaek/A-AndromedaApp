package com.example.andromedaapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.Button
import android.widget.ListView
import android.widget.Toast

class Centros : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_centros)

        var centros:ArrayList<Centro> = ArrayList(0)
        centros.add(Centro("FELIPE CARRILLO PUERTO", R.drawable.andromeda1))
        centros.add(Centro("ADOPT ME, CHETUMAL", R.drawable.andromeda1))
        centros.add(Centro("TULUM", R.drawable.andromeda1))
        centros.add(Centro("CANCUN", R.drawable.andromeda1))
        centros.add(Centro("PLAYA DEL CARMEN", R.drawable.andromeda1))

        val lista = findViewById<ListView>(R.id.lista)

        // val adaptador = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, frutas)
        val adaptador = AdaptadorCustomC(this, centros)

        lista.adapter = adaptador

        lista.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            Toast.makeText(this, centros.get(position).nombre, Toast.LENGTH_LONG).show()
        }

        val mensaje = intent.getStringExtra("MENSAJE")

        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()

        val botonC = findViewById<Button>(R.id.botonC)
        botonC.setOnClickListener {
            var intent = Intent(this, Perros::class.java)
            intent.putExtra("MENSAJE", "HACIA ACTIVIDAD C")
            intent.putExtra("MENSAJEA", mensaje)
            startActivity(intent)
        }
    }
}
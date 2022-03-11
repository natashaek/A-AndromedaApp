package com.example.andromedaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.GridView
import android.widget.Toast

class Perros (nombre:String, imagen:Int): AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perros)

        var perros = ArrayList<Perro>()
        perros.add(Perro("Plutto", "2 años", R.drawable.andromeda1))
        perros.add(Perro("Maximus", "4 años",R.drawable.andromeda1))
        perros.add(Perro("Puppy","1 año", R.drawable.andromeda1))
        perros.add(Perro("Astro","8 meses", R.drawable.maximus))
        perros.add(Perro("Eufo","3 años", R.drawable.rikko))
        perros.add(Perro("Rikko", "1 año",R.drawable.astro))



        var grid: GridView = findViewById(R.id.grid)
        // val adaptador = ArrayAdapter<String> (this, android.R.layout.simple_list_item_1, frutas)
        val adaptador  =AdaptadorCustomP(this, perros)
        grid.adapter = adaptador

        grid.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            Toast.makeText(this, perros.get(position).nombre, Toast.LENGTH_LONG).show()
        }

        val mensaje = intent.getStringExtra("MENSAJE")

        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()
    }


}
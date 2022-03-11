package com.example.andromedaapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class AdaptadorCustomP(var context: Context, items:ArrayList<Perro>): BaseAdapter() {

    var items:ArrayList<Perro>? = null

    init {
       this.items = items
    }
    override fun getCount(): Int {
        return items?.count()!!
    }

    override fun getItem(position: Int): Any {
        return items?.get(position)!!
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var vista = convertView
        var holder:ViewHolder? = null
        if(vista == null){
            vista = LayoutInflater.from(context).inflate(R.layout.perros,null)
            holder = ViewHolder(vista)
            vista.tag = holder

            /*if(position %2 == 1){
                vista.setBackgroundColor(Color.GRAY)
            }else{
                vista.setBackgroundColor(Color.WHITE)
            }*/


        }else {
            holder = vista.tag as? ViewHolder
        }
        val item = items?.get(position)
        holder?.nombre?.text = item?.nombre
        holder?.imagen?.setImageResource(item?.imagen!!)
        holder?.edad?.text = item?.edad

        return vista!!
    }

    private class  ViewHolder(vista:View) {
        var nombre:TextView? = null
        var imagen:ImageView? = null
        var edad:TextView? = null

        init {
            nombre = vista.findViewById(R.id.nombre)
            imagen = vista.findViewById(R.id.imagen)
            edad = vista.findViewById(R.id.edad)
        }
    }
}
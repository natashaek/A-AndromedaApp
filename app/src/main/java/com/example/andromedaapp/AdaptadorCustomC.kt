package com.example.andromedaapp

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class AdaptadorCustomC(var context: Context, items: ArrayList<Centro>):BaseAdapter() {

    var items:ArrayList<Centro>? = null

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
        var holder:ViewHolder? = null
        var vista:View? = convertView

        if(vista == null){
            vista = LayoutInflater.from(context).inflate(R.layout.centros, null)
            holder = ViewHolder(vista)
            vista.tag = holder

            if(position %2 == 1){
                vista.setBackgroundColor(Color.LTGRAY)
            }else{
                vista.setBackgroundColor(Color.TRANSPARENT)
            }
        } else {
            holder = vista.tag as? ViewHolder
        }

        val item = getItem(position) as Centro
        holder?.nombre?.text = item.nombre
        holder?.imagen?.setImageResource(item.imagen)

        return vista!!
    }

    private  class  ViewHolder(vista:View) {
        var nombre:TextView? = null
        var imagen: ImageView? = null
        init {
            nombre = vista.findViewById(R.id.nombre)
            imagen = vista.findViewById(R.id.imagen)
        }
    }

}
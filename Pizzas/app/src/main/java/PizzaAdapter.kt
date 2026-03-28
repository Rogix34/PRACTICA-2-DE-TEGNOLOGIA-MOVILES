package com.example.pizzas

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView

class PizzaAdapter(private val context: Context) : BaseAdapter() {

    val imagenes = intArrayOf(
        R.drawable.ic_launcher_foreground,
        R.drawable.ic_launcher_foreground,
        R.drawable.ic_launcher_foreground,
        R.drawable.ic_launcher_foreground
    )

    override fun getCount(): Int = imagenes.size

    override fun getItem(position: Int): Any = imagenes[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val imageView = ImageView(context)
        imageView.setImageResource(imagenes[position])
        imageView.layoutParams = ViewGroup.LayoutParams(300, 300)
        imageView.scaleType = ImageView.ScaleType.CENTER_CROP
        return imageView
    }
}
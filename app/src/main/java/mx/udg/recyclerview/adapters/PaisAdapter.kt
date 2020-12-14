package mx.udg.recyclerview.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.Placeholder
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.pais_item.view.*
import mx.udg.recyclerview.R
import mx.udg.recyclerview.modelos.Pais

class PaisAdapter(paises:ArrayList<Pais>, contexto:Context):RecyclerView.Adapter<PaisAdapter.ViewHolder>(){
    var paises:ArrayList<Pais>?=null
    var contexto:Context?=null

    init {
        this.paises = paises
        this.contexto = contexto
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val vistaPais:View = LayoutInflater
            .from(contexto)
            .inflate(R.layout.pais_item,parent,false)
        val paisViewHolder = ViewHolder(vistaPais)
        vistaPais.tag = paisViewHolder
        return paisViewHolder
    }

    override fun getItemCount(): Int {
        return this.paises!!.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pais = paises!![position]
        holder.tvnombre!!.text = pais.nombre
        Picasso.get().load(pais.imagen)
            .placeholder(R.drawable.ic_launcher_background)
            .into(holder.ImagenFondo)
    }

    class ViewHolder(vista:View):RecyclerView.ViewHolder(vista){
        var ImagenFondo:ImageView?=null
        var tvnombre:TextView?=null
        //me quede en el 28:30 del vídeo
        init {
            ImagenFondo = vista.findViewById(R.id.idfondo)
            tvnombre = vista.findViewById(R.id.tvnombre)
        }
    }

}

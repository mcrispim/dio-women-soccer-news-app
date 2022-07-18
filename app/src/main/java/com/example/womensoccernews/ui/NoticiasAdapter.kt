package com.example.womensoccernews.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.womensoccernews.databinding.NoticiaItemBinding
import com.example.womensoccernews.ui.home.Noticia

class NoticiasAdapter(val listaNoticias: List<Noticia>): RecyclerView.Adapter<NoticiasAdapter.NoticiaViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoticiaViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = NoticiaItemBinding.inflate(layoutInflater, parent, false)
                return NoticiaViewHolder(binding)
        }

        override fun onBindViewHolder(holder: NoticiaViewHolder, position: Int) {
                val noticia = listaNoticias[position]
                holder.binding.tvTitulo.text = noticia.titulo
                holder.binding.tvTexto.text = noticia.texto
        }

        override fun getItemCount() = listaNoticias.size

        inner  class NoticiaViewHolder(val binding: NoticiaItemBinding): RecyclerView.ViewHolder(binding.root) {

        }

}
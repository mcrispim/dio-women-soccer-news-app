package com.example.womensoccernews.ui

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.womensoccernews.databinding.NoticiaItemBinding
import com.example.womensoccernews.ui.home.Noticia
import com.squareup.picasso.Picasso

class NoticiasAdapter(private val listaNoticias: List<Noticia>): RecyclerView.Adapter<NoticiasAdapter.NoticiaViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoticiaViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = NoticiaItemBinding.inflate(layoutInflater, parent, false)
                return NoticiaViewHolder(binding)
        }

        override fun onBindViewHolder(holder: NoticiaViewHolder, position: Int) {
                val noticia = listaNoticias[position]
                Picasso.get()
                        .load(noticia.imagem)
                        .into(holder.binding.ivImagem)
                holder.binding.tvTitulo.text = noticia.titulo
                holder.binding.tvTexto.text = noticia.texto
                holder.binding.btLink.setOnClickListener { _ ->
                        val openURL = Intent(Intent.ACTION_VIEW)
                        openURL.data = Uri.parse(noticia.link)
                        holder.itemView.context.startActivity(openURL)
                }
        }

        override fun getItemCount() = listaNoticias.size

        inner  class NoticiaViewHolder(val binding: NoticiaItemBinding): RecyclerView.ViewHolder(binding.root) {

        }

}
package com.example.womensoccernews.ui

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.womensoccernews.databinding.NoticiaItemBinding
import com.example.womensoccernews.ui.noticias.Noticia
import com.squareup.picasso.Picasso

class NoticiasAdapter(private val listaNoticias: List<Noticia>, private val favoriteListener: View.OnClickListener): RecyclerView.Adapter<NoticiasAdapter.NoticiaViewHolder>() {

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

                // implementação da funcionalidade Link para a Notícia
                holder.binding.btLink.setOnClickListener { _ ->
                        val intentOpenURL = Intent(Intent.ACTION_VIEW)
                        intentOpenURL.data = Uri.parse(noticia.link)
                        holder.itemView.context.startActivity(intentOpenURL)
                }

                // implementação da funcionalidade Share da Notícia
                holder.binding.ivShare.setOnClickListener { _ ->
                        val intentShareURL = Intent(Intent.ACTION_SEND)
                        intentShareURL.type ="text/plain"
                        intentShareURL.putExtra(Intent.EXTRA_TEXT, noticia.link)
                        holder.itemView.context.startActivity(Intent.createChooser(intentShareURL, "Share via"))
                }

                // Implementação da funcionalidade favorito da notícia
                holder.binding.ivFavorito.setOnClickListener(favoriteListener)
        }

        override fun getItemCount() = listaNoticias.size

        inner  class NoticiaViewHolder(val binding: NoticiaItemBinding): RecyclerView.ViewHolder(binding.root) {

        }

}
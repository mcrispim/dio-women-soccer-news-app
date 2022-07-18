package com.example.womensoccernews.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.womensoccernews.databinding.FragmentNoticiasBinding
import com.example.womensoccernews.ui.NoticiasAdapter

class NoticiasFragment : Fragment() {

    private var _binding: FragmentNoticiasBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(NoticiasViewModel::class.java)

        _binding = FragmentNoticiasBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val recyclerView = binding.rvNoticias
        recyclerView.layoutManager = LinearLayoutManager(this.context)

        homeViewModel.listaNoticias.observe(viewLifecycleOwner) { listaNoticias ->
            recyclerView.adapter = NoticiasAdapter(listaNoticias)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
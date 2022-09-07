package com.example.navigationpractice.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.navigationpractice.databinding.FragmentNoteDetailBinding

class NoteDetailFragment : Fragment() {

    private var _binding : FragmentNoteDetailBinding? = null
    private val binding get() = _binding!!

    private lateinit var number: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            number = it.getString("Content").toString()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNoteDetailBinding.inflate(inflater,container, false)
        var view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.noteContent.text = number.toString()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
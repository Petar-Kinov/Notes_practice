package com.example.navigationpractice

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.navigationpractice.Fragments.NotesListFragmentDirections
import com.example.navigationpractice.Model.Note
import com.example.navigationpractice.databinding.FragmentNotesListBinding
import com.example.navigationpractice.databinding.NoteCardBinding

private const val TAG = "NoteAdaper"

class NoteAdaper(private val context: Context, private val dataset: List<Note>) : RecyclerView.Adapter<NoteAdaper.NoteViewHolder>() {

    inner class NoteViewHolder(private val binding : NoteCardBinding) : RecyclerView.ViewHolder(binding.root) {

        val textView = binding.noteTitle
        val cardView = binding.cardView

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val binding = NoteCardBinding.inflate(LayoutInflater.from(parent.context) , parent , false)
        return NoteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.textView.text = dataset[position].title

        holder.cardView.setOnClickListener{
            Log.d("TAG", "onBindViewHolder: Note $position clicked")

            val action = NotesListFragmentDirections.actionNotesListFragmentToNoteDetailFragment2(dataset[position].title)
            holder.itemView.findNavController().navigate(action)
        }
    }

    override fun getItemCount()= dataset.size

}
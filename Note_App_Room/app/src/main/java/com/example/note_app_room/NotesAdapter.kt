package com.example.note_app_room

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_note.view.*

class NotesAdapter(private val allNotes: ArrayList<Note>, private val listener: INotesRVAdapter)
    : RecyclerView.Adapter<NotesAdapter.NoteViewHolder>() {

    inner class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val mTvData = itemView.findViewById<TextView>(R.id.tvData)
        val mIvDelete = itemView.findViewById<ImageView>(R.id.ivDelete)

        fun setData(note: Note){
            itemView.apply {
                tvData.text=note.text
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val viewHolder =NoteViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_note,parent,false))
        viewHolder.mIvDelete.setOnClickListener {
            listener.onItemClicked(allNotes[viewHolder.adapterPosition])

        }

        return viewHolder
    }

    override fun getItemCount(): Int {
        return allNotes.size
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
    holder.setData(allNotes.get(position))
    }


    fun updateData(newList : List<Note>){
        allNotes.clear()
        allNotes.addAll(newList)

        notifyDataSetChanged()
    }
}
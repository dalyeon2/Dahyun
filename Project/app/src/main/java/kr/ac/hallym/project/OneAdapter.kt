package kr.ac.hallym.project

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kr.ac.hallym.project.databinding.ActivityStoryBinding
import kr.ac.hallym.project.databinding.CommentRecyclerviewBinding

class OneViewHolder(val binding: CommentRecyclerviewBinding) : RecyclerView.ViewHolder(binding.root)

class OneAdapter(val contents1: MutableList<String>?) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        OneViewHolder(CommentRecyclerviewBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false))

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding = (holder as OneViewHolder).binding
        binding.itemData.text = contents1!![position]
    }

    override fun getItemCount(): Int {
        return contents1?.size ?: 0
    }
}
package com.example.feedviewer.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.feedviewerapp.data.local.CharacterEntity
import com.example.feedviewerapp.databinding.ItemCharacterBinding

class CharacterAdapter(
    private var items: List<CharacterEntity>,
    private val onItemClick: (CharacterEntity) -> Unit
) : RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    inner class CharacterViewHolder(private val binding: ItemCharacterBinding)
        : RecyclerView.ViewHolder(binding.root) {

        fun bind(character: CharacterEntity) {
            binding.nameText.text = character.name
            binding.statusText.text = "Status: ${character.status}"
            binding.speciesText.text = "Species: ${character.species}"

            Glide.with(binding.root.context)
                .load(character.image)
                .into(binding.imageView)

            binding.root.setOnClickListener {
                onItemClick(character)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val binding = ItemCharacterBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CharacterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    fun updateData(newItems: List<CharacterEntity>) {
        items = newItems
        notifyDataSetChanged()
    }
}

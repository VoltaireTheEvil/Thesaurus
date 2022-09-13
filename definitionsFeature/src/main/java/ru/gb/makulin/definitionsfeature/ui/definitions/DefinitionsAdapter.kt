package ru.gb.makulin.definitionsfeature.ui.definitions

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.gb.makulin.core.domainmodel.Sense
import ru.gb.makulin.definitionsfeature.databinding.FragmentDefinitionsRecyclerItemBinding

internal class DefinitionsAdapter :
    ListAdapter<Sense, DefinitionsAdapter.SenseViewHolder>(ResultItemCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SenseViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return SenseViewHolder(
            FragmentDefinitionsRecyclerItemBinding.inflate(layoutInflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: SenseViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class SenseViewHolder(private val binding: FragmentDefinitionsRecyclerItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(sense: Sense) {
            with(binding) {
                definitionTextView.text = sense.definitions[0]
                examplesTextView.text = sense.examples.joinToString(separator = "\n")
                synonymsTextView.text = sense.synonyms.joinToString()
            }
        }
    }
}

class ResultItemCallback : DiffUtil.ItemCallback<Sense>() {
    override fun areItemsTheSame(oldItem: Sense, newItem: Sense): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Sense, newItem: Sense): Boolean {
        return oldItem.definitions == newItem.definitions
    }

}

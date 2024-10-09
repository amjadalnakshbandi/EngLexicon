package com.example.dictionary

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dictionary.databinding.MeaningRecyclerRowBinding

class MeaningAdapter(private var meaningList: List<Meaning>) : RecyclerView.Adapter<MeaningAdapter.MeaningViewHolder>() {

    class MeaningViewHolder(private val binding: MeaningRecyclerRowBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(meaning: Meaning) {
              binding.partOfSpeechTextView.text= meaning.partOfSpeech
              binding.definitionsTextView.text= meaning.definitions.joinToString("\n\n") {
                  var currentIndex= meaning.definitions.indexOf(it)
                  (currentIndex+1).toString()+ "." + it.definition.toString()
              }
            if (meaning.synonyms.isEmpty()){
                binding.synonymsTextView.visibility= View.INVISIBLE
                binding.synonymsTitleTextView.visibility= View.VISIBLE
            }else{
                binding.synonymsTextView.visibility= View.VISIBLE
                binding.synonymsTitleTextView.visibility= View.VISIBLE
                binding.synonymsTextView.text= meaning.synonyms.joinToString(", ")
            }
            if (meaning.antonyms.isEmpty()){
                binding.antonoymsTitleTextView.visibility= View.INVISIBLE
                binding.antonoymsTextView.visibility= View.VISIBLE
            }else{
                binding.antonoymsTitleTextView.visibility= View.VISIBLE
                binding.antonoymsTextView.visibility= View.VISIBLE
                binding.antonoymsTitleTextView.text= meaning.antonyms.joinToString(", ")
            }
        }
    }

    fun updateNewData(newMeaningList: List<Meaning>) {
        meaningList = newMeaningList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MeaningViewHolder {
        val binding = MeaningRecyclerRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MeaningViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return meaningList.size
    }

    override fun onBindViewHolder(holder: MeaningViewHolder, position: Int) {
        holder.bind(meaningList[position])
    }
}

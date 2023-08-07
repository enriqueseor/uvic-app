package cat.teknos.uvicapp.view.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import cat.teknos.uvicapp.databinding.ItemEventsBinding
import cat.teknos.uvicapp.data.model.EventModel

class EventViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val binding = ItemEventsBinding.bind(view)

    fun render(eventModel: EventModel, onClickListener:(EventModel) -> Unit){
        binding.tvEventDay.text = eventModel.day
        binding.tvEventMonth.text = eventModel.month
        binding.tvEventName.text = eventModel.eventName
        itemView.setOnClickListener{onClickListener(eventModel)}
    }
}
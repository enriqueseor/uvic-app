package cat.teknos.uvicapp.eventsfragment.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import cat.teknos.uvicapp.databinding.ItemEventsBinding
import cat.teknos.uvicapp.eventsfragment.event.Event

class EventViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val binding = ItemEventsBinding.bind(view)

    fun render(eventModel: Event, onClickListener:(Event) -> Unit){
        binding.tvEventDay.text = eventModel.day
        binding.tvEventMonth.text = eventModel.month
        binding.tvEventName.text = eventModel.eventName
        itemView.setOnClickListener{onClickListener(eventModel)}
    }
}
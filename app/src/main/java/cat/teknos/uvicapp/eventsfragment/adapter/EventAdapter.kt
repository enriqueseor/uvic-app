package cat.teknos.uvicapp.eventsfragment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cat.teknos.uvicapp.R
import cat.teknos.uvicapp.eventsfragment.event.Event

class EventAdapter(private val eventList:List<Event>, private val onClickListener:(Event) -> Unit) : RecyclerView.Adapter<EventViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return EventViewHolder(layoutInflater.inflate(R.layout.item_events, parent, false))
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        val item = eventList[position]
        holder.render(item, onClickListener)
    }

    override fun getItemCount(): Int = eventList.size
}
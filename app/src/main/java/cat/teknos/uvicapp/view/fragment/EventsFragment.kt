package cat.teknos.uvicapp.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import cat.teknos.uvicapp.databinding.FragmentEventsBinding
import cat.teknos.uvicapp.view.adapter.EventAdapter
import cat.teknos.uvicapp.data.EventProvider

class EventsFragment : Fragment() {

    private lateinit var binding: FragmentEventsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentEventsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        val manager = LinearLayoutManager(requireContext())
        val decoration = DividerItemDecoration(requireContext(), manager.orientation)
        binding.rvEvents.layoutManager = manager
        binding.rvEvents.adapter = EventAdapter(EventProvider.eventList) {
        onItemSelected()
        }
        binding.rvEvents.addItemDecoration(decoration)
    }

    private fun onItemSelected() {}
}
package com.example.busfleetsapplication.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.busfleetsapplication.R
import com.example.busfleetsapplication.model.ItemAdapter
import com.example.busfleetsapplication.model.Model


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [WorkFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class WorkFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    var recyclerView: RecyclerView? = null
    var itemList: List<Model>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_work, container, false)

        recyclerView = view.findViewById<View>(R.id.scheduleRecyclerView) as RecyclerView?
        recyclerView?.setHasFixedSize(true)
        recyclerView?.setLayoutManager(LinearLayoutManager(context))

        recyclerView?.setAdapter(context?.let { ItemAdapter(initData() as List<Model>, it) })

        return view
    }

    private fun initData(): List<Model?>? {
        itemList = ArrayList()
        (itemList as ArrayList<Model>).add(Model(R.drawable.ic_bus, "Алматы - Семей"))
        (itemList as ArrayList<Model>).add(Model(R.drawable.ic_bus, "Алматы - Шымкент"))
        (itemList as ArrayList<Model>).add(Model(R.drawable.ic_bus, "Алматы - Тараз"))
        return itemList
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment WorkFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            WorkFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
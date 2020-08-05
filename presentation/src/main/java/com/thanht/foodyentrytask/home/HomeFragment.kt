package com.thanht.foodyentrytask.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.SimpleItemAnimator
import com.thanht.foodyentrytask.R
import com.thanht.foodyentrytask.ext.userComponent
import com.thanht.foodyentrytask.home.list.CityInfo
import com.thanht.foodyentrytask.home.list.CityListAdapter
import com.thanht.foodyentrytask.home.list.CityListViewModel
import kotlinx.android.synthetic.main.fragment_home.*
import javax.inject.Inject

class HomeFragment : Fragment() {

    private val adapter = CityListAdapter()

    @Inject
    lateinit var cityListViewModel: CityListViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        requireActivity().userComponent().inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
        cityListViewModel.cityListResult.observe(requireActivity(), Observer {
            val cityListResult = it ?: return@Observer
            cityListResult.error?.let { errorMsg ->
                showError(errorMsg)
            }
            cityListResult.success?.let { data ->
                adapter.setData(data)
            }
        })
        cityListViewModel.getListCity()
    }

    private fun showError(msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }

    private fun initUI() {
        rv_city.apply {
            layoutManager = LinearLayoutManager(context)
            (itemAnimator as SimpleItemAnimator).supportsChangeAnimations = false
            adapter = this@HomeFragment.adapter
        }
    }
}
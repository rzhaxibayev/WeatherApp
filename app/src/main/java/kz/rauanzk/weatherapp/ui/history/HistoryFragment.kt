package kz.rauanzk.weatherapp.ui.history

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_history.*
import kz.rauanzk.weatherapp.R
import kz.rauanzk.weatherapp.databinding.FragmentHistoryBinding
import kz.rauanzk.weatherapp.ui.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class HistoryFragment : BaseFragment<HistoryViewModel, FragmentHistoryBinding>() {

    override val viewModel: HistoryViewModel by viewModel()

    private val weathersAdapter = WeathersAdapter()

    override fun init() {
        super.init()
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnSave.setOnClickListener {
            viewModel.fetchCurrentWeather("Almaty")
        }

        viewModel.weathers.observe(viewLifecycleOwner, Observer { weathers ->
            weathersAdapter.update(weathers.reversed())
        })

        rvWeathers.layoutManager = LinearLayoutManager(context)
        rvWeathers.adapter = weathersAdapter
        weathersAdapter.setOnItemClick { weatherData ->
            val action =
                HistoryFragmentDirections.actionHistoryFragmentToDetailFragment(weatherData, weatherData.name)
            navigate(R.id.activityNavigation, action)
        }
    }

    override fun getLayoutRes(): Int = R.layout.fragment_history
}
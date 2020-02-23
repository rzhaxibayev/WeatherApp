package kz.rauanzk.weatherapp.ui.detail

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import kz.rauanzk.weatherapp.R
import kz.rauanzk.weatherapp.databinding.FragmentDetailBinding
import kz.rauanzk.weatherapp.ui.base.BaseFragment
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_detail.*
import kz.rauanzk.weatherapp.utils.format
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailFragment : BaseFragment<DetailViewModel, FragmentDetailBinding>() {

    override val viewModel: DetailViewModel by viewModel()

    private val args: DetailFragmentArgs by navArgs()

    override fun init() {
        super.init()
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val weatherData = args.data
        tvDate.text = "Time: ${weatherData.time.format()}"
        tvTemperature.text = "Temperature: ${weatherData.main?.temperature}K"

        tvTemperatureMin.text = "Temperature Min: ${weatherData.main?.temperatureMin}K"
        tvTemperatureMax.text = "Temperature Max: ${weatherData.main?.temperatureMax}K"

        tvPressure.text = "Pressure: ${weatherData.main?.pressure}Pa"
    }

    override fun getLayoutRes(): Int = R.layout.fragment_detail
}
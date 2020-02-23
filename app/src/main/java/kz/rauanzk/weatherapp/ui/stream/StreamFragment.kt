package kz.rauanzk.weatherapp.ui.stream

import kz.rauanzk.weatherapp.R
import kz.rauanzk.weatherapp.databinding.FragmentStreamBinding
import kz.rauanzk.weatherapp.ui.base.BaseFragment
import org.bytedeco.javacv.FFmpegFrameRecorder
import org.koin.androidx.viewmodel.ext.android.viewModel

class StreamFragment : BaseFragment<StreamViewModel, FragmentStreamBinding>() {

    override val viewModel: StreamViewModel by viewModel()

    private val ffmpeg_link = "rtmp://live.mux.com/app/339cecd7-19fd-b52d-56e0-6dfa6ed9653c"

    var startTime = 0L
    var recording = false

    var recorder: FFmpegFrameRecorder? = null

    private var isPreviewOn = false

    init {
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
    }


    override fun getLayoutRes(): Int = R.layout.fragment_stream

}
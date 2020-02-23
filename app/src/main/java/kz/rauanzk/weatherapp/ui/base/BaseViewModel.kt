package kz.rauanzk.weatherapp.ui.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kz.rauanzk.weatherapp.data.api.base.BaseData
import kz.rauanzk.weatherapp.data.api.base.Result
import kz.rauanzk.weatherapp.utils.Event
import timber.log.Timber

open class BaseViewModel : ViewModel() {

    val showToastEvent = MutableLiveData<Event<String>>()

    fun <T : Any> apiCall(
        call: suspend () -> Result<Any>,
        onSuccess: ((T) -> Unit)? = null,
        onError: ((String?) -> Unit)? = null,
        loading: (() -> Unit)? = null,
        onComplete: (() -> Unit)? = null
    ) {
        loading?.invoke()

        viewModelScope.launch {

            when (val result = call.invoke()) {
                is Result.Success<*> -> {
                    val data = result.data
                    if (data is BaseData) {
                        if (data.cod == 200) {
                            onSuccess?.invoke(data as T)
                        } else {
                            val message = data.message ?: "Unknown onError"
                            onError?.invoke(message)
                        }
                    } else {
                        Timber.d("Unexpected onError")
                        onError?.invoke("Unexpected onError")
                    }
                }
                is Result.Error -> {
                    onError?.invoke(result.exception.message)
                }
            }

            onComplete?.invoke()
        }
    }
}
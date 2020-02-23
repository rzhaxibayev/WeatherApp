package kz.rauanzk.weatherapp.data.repository.base

import kz.rauanzk.weatherapp.data.api.base.Result
import retrofit2.Response
import java.io.IOException

open class BaseRepository {

    suspend fun <T : Any> safeApiCall(call: suspend () -> Response<T>): Result<T> {
        return try {
            val response = call()
            if (response.isSuccessful) {
                Result.Success(response.body()!!)
            } else {
                Result.Error(IOException("Error in safe api call"))
            }
        } catch (e: Exception) {
            Result.Error(e)
        }
    }
}
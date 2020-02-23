package kz.rauanzk.weatherapp.data.entity

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kz.rauanzk.weatherapp.data.api.base.BaseData

@Entity(tableName = "weathers")
data class CurrentWeatherData(
    @PrimaryKey(autoGenerate = true)
    val weatherId: Long,

    var time: Long = 0,

    val name: String?,

    @Embedded
    val main: Main?
) : BaseData(), Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readLong(),
        parcel.readLong(),
        parcel.readString(),
        parcel.readParcelable(Main::class.java.classLoader)
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(weatherId)
        parcel.writeLong(time)
        parcel.writeString(name)
        parcel.writeParcelable(main, flags)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<CurrentWeatherData> {
        override fun createFromParcel(parcel: Parcel): CurrentWeatherData {
            return CurrentWeatherData(parcel)
        }

        override fun newArray(size: Int): Array<CurrentWeatherData?> {
            return arrayOfNulls(size)
        }
    }

}

data class Main(
    @SerializedName("temp")
    val temperature: Double,

    @SerializedName("temp_min")
    val temperatureMin: Double,

    @SerializedName("temp_max")
    val temperatureMax: Double,

    val pressure: Long
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readLong()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeDouble(temperature)
        parcel.writeDouble(temperatureMin)
        parcel.writeDouble(temperatureMax)
        parcel.writeLong(pressure)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<Main> {
        override fun createFromParcel(parcel: Parcel): Main {
            return Main(parcel)
        }

        override fun newArray(size: Int): Array<Main?> {
            return arrayOfNulls(size)
        }
    }
}
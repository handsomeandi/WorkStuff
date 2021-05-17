package com.example.weatherproj.fragments


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.weatherproj.R
import com.example.weatherproj.networkobjects.DaggerNetworkComponent
import com.example.weatherproj.networkobjects.NetworkComponent
import com.example.weatherproj.networkobjects.NetworkModule
import com.example.weatherproj.networkobjects.ServerApi
import com.example.weatherproj.weatherobjects.Weather
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [WeatherFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class WeatherFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var sunset : TextView
    private lateinit var wetness : TextView
    private lateinit var wind_speed : TextView
    private lateinit var weather_cond : TextView
    private lateinit var sunrise : TextView
    private lateinit var current_temp : TextView
    val ERROR = "ERROR"


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        sunset = view.findViewById(R.id.sunsetTv)
        sunrise = view.findViewById(R.id.sunriseTv)
        wind_speed = view.findViewById(R.id.windSpeedTv)
        weather_cond = view.findViewById(R.id.weatherCondTv)
        wetness = view.findViewById(R.id.wetnessTv)
        current_temp = view.findViewById(R.id.currentTempTv)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val component: NetworkComponent =

            DaggerNetworkComponent.builder().networkModule(NetworkModule()).build()
        val serverApi: ServerApi = component.getServerApi()

        serverApi.getWeatherData()!!.enqueue(object : Callback<Weather?> {
            override fun onResponse(call: Call<Weather?>?, response: Response<Weather?>) {
                if (response.isSuccessful()) {
                    sunset.setText(
                        java.lang.String.format(
                            "%s%s",
                            getString(R.string.sunset),
                            response.body()!!.getSunset()
                        )
                    )
                    wetness.setText(
                        java.lang.String.format(
                            "%s%s",
                            getString(R.string.humidity),
                            response.body()!!.getHumidity()
                        )
                    )
                    wind_speed.setText(
                        java.lang.String.format(
                            "%s%s",
                            getString(R.string.wind_speed),
                            response.body()!!.getWindSpeed()
                        )
                    )
                    weather_cond.setText(
                        java.lang.String.format(
                            "%s%s",
                            getString(R.string.weather_cond),
                            response.body()!!.getWeatherConditions()
                        )
                    )
                    sunrise.setText(
                        java.lang.String.format(
                            "%s%s",
                            getString(R.string.sunrise),
                            response.body()!!.getSunrise()
                        )
                    )
                    current_temp.setText(
                        java.lang.String.format(
                            "%s%s C",
                            getString(R.string.current_temp),
                            response.body()!!.getTemp()
                        )
                    )
                } else {
                    Log.d(ERROR, response.message())
                }
            }

            override fun onFailure(call: Call<Weather?>?, t: Throwable) {
                Log.d(ERROR, t.message!!)
            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_weather, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment WeatherFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            WeatherFragment().apply {
            }
    }
}
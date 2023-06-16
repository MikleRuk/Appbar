package Categories

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {

    val basUrl = "https://run.mocky.io/"

    fun getInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(basUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}
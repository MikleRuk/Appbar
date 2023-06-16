package dishes

import retrofit2.Response
import retrofit2.http.GET

interface DishesApi {
    @GET("v3/c7a508f2-a904-498a-8539-09d96785446e")
    suspend fun getDishes () : Response<DataClassDishes>
}


package dishes

import com.google.gson.annotations.SerializedName


@kotlinx.serialization.Serializable
data class DataClassDishes(

    @SerializedName("dishes") var dishes: ArrayList<Dishes> = arrayListOf()
)



@kotlinx.serialization.Serializable
data class Dishes(

    @SerializedName("id") var id: Int? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("price") var price: Int? = null,
    @SerializedName("weight") var weight: Int? = null,
    @SerializedName("description") var description: String? = null,
    @SerializedName("image_url") var imageUrl: String? = null,
    @SerializedName("tegs") var tegs: ArrayList<String> = arrayListOf()

)

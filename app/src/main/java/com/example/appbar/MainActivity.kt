package com.example.appbar

import Categories.RetrofitHelper
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.example.appbar.databinding.ActivityMainBinding
import com.squareup.picasso.Picasso
import dishes.DataClassDishes
import dishes.Dishes
import dishes.DishesApi
import kotlinx.coroutines.launch
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val categoriesApi = RetrofitHelper.getInstance().create(DishesApi::class.java)

        lifecycleScope.launch {


            val response: Response<DataClassDishes> = categoriesApi.getDishes()
            val dataClassDishes: DataClassDishes? = response.body()
            val dishesList = dataClassDishes?.dishes
            val dishesJson = Json.encodeToString(dishesList)
            val json = Json { ignoreUnknownKeys = true }
            val deserializedDishesList =
                json.decodeFromString<List<Dishes>>(dishesJson)
            for (i in 0 until deserializedDishesList.size) {
                when (i) {
                    0 -> {
                        val category = deserializedDishesList[i]
                        val id: Int? = category.id
                        val name: String? = category.name
                        val image_url: String? = category.imageUrl
                        val description: String? = category.description
                        with(binding) {
                            tvTitle1.text = name
                            tvDescription1.text = description
                        }

                        Picasso.get().load(image_url).into(binding.im1)
                    }
//                    1 -> {
//                        val category = deserializedDishesList[i]
//                        val id: Int? = category.id
//                        val name: String? = category.name
//                        val image_url: String? = category.imageUrl
//                        val weight: Int? = category.weight
//                        val price: Int? = category.price
//                        val description: String? = category.description
//                        binding.tvImbDish2.text = name
//                        Picasso.get().load(image_url).into(binding.imBtnDish2)
//                    }
//                    2 -> {
//                        val category = deserializedDishesList[i]
//                        val id: Int? = category.id
//                        val name: String? = category.name
//                        val image_url: String? = category.imageUrl
//                        val weight: Int? = category.weight
//                        val price: Int? = category.price
//                        val description: String? = category.description
//                        binding.tvImbDish3.text = name
//                        Picasso.get().load(image_url).into(binding.imBtnDish3)
//                    }
//                    3 -> {
//                        val category = deserializedDishesList[i]
//                        val id: Int? = category.id
//                        val name: String? = category.name
//                        val image_url: String? = category.imageUrl
//                        val weight: Int? = category.weight
//                        val price: Int? = category.price
//                        val description: String? = category.description
//                        binding.tvImbDish4.text = name
//                        Picasso.get().load(image_url).into(binding.imBtnDish4)
//                    }
//                    4 -> {
//                        val category = deserializedDishesList[i]
//                        val id: Int? = category.id
//                        val name: String? = category.name
//                        val image_url: String? = category.imageUrl
//                        val weight: Int? = category.weight
//                        val price: Int? = category.price
//                        val description: String? = category.description
//                        binding.tvImbDish5.text = name
//                        Picasso.get().load(image_url).into(binding.imBtnDish5)
//                    }
//                    5 -> {
//                        val category = deserializedDishesList[i]
//                        val id: Int? = category.id
//                        val name: String? = category.name
//                        val image_url: String? = category.imageUrl
//                        val weight: Int? = category.weight
//                        val price: Int? = category.price
//                        val description: String? = category.description
//                        binding.tvImbDish6.text = name
//                        Picasso.get().load(image_url).into(binding.imBtnDish6)
//                    }


                }


            }
        }
    }
}
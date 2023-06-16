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
                        val price: Int? = category.price
                        with(binding) {
                            tvTitle1.text = name
                            tvDescription1.text = description
                            tvImBt1.text = "от $price Р"
                        }

                        Picasso.get().load(image_url).into(binding.im1)
                    }
                    1 -> {
                        val category = deserializedDishesList[i]
                        val id: Int? = category.id
                        val name: String? = category.name
                        val image_url: String? = category.imageUrl
                        val description: String? = category.description
                        val price: Int? = category.price
                        with(binding) {
                            tvTitle2.text = name
                            tvDescription2.text = description
                            tvImBt2.text = "от $price Р"
                        }

                        Picasso.get().load(image_url).into(binding.im2)
                    }
                    2 -> {
                        val category = deserializedDishesList[i]
                        val id: Int? = category.id
                        val name: String? = category.name
                        val image_url: String? = category.imageUrl
                        val description: String? = category.description
                        val price: Int? = category.price
                        with(binding) {
                            tvTitle3.text = name
                            tvDescription3.text = description
                            tvImBt3.text = "от $price Р"
                        }

                        Picasso.get().load(image_url).into(binding.im3)
                    }
                    6 -> {
                        val category = deserializedDishesList[i]
                        val id: Int? = category.id
                        val name: String? = category.name
                        val image_url: String? = category.imageUrl
                        val description: String? = category.description
                        val price: Int? = category.price
                        with(binding) {
                            tvTitle4.text = name
                            tvDescription4.text = description
                            tvImBt4.text = "от $price Р"
                        }

                        Picasso.get().load(image_url).into(binding.im4)
                    }

                    5 -> {
                        val category = deserializedDishesList[i]
                        val id: Int? = category.id
                        val name: String? = category.name
                        val image_url: String? = category.imageUrl
                        val description: String? = category.description
                        val price: Int? = category.price
                        with(binding) {
                            tvTitle5.text = name
                            tvDescription5.text = description
                            tvImBt5.text = "от $price Р"
                        }

                        Picasso.get().load(image_url).into(binding.im5)
                    }


                }


            }
        }
    }
}
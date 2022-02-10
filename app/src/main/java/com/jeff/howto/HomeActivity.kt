package com.jeff.howto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.jeff.howto.adapter.MainCategoryAdapter
import com.jeff.howto.adapter.SubCategoryAdapter
import com.jeff.howto.databinding.ActivityHomeBinding
import com.jeff.howto.entities.Recipes


class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    var arrMainCategory = ArrayList<Recipes>()
    var arrSubCategory = ArrayList<Recipes>()

    var mainCategoryAdapter = MainCategoryAdapter()
    var subCategoryAdapter = SubCategoryAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityHomeBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        arrMainCategory.add(Recipes(1, "Beef"))
        arrMainCategory.add(Recipes(2, "Chicken"))
        arrMainCategory.add(Recipes(3, "Dessert"))
        arrMainCategory.add(Recipes(4, "Lamb"))
        arrMainCategory.add(Recipes(5, "Fries"))

        mainCategoryAdapter.setData(arrMainCategory)

        arrSubCategory.add(Recipes(1, "Beef and Mustard Pie"))
        arrSubCategory.add(Recipes(2, "Chicken and Mushroom Soup"))
        arrSubCategory.add(Recipes(3, "Banana Pancakes"))
        arrSubCategory.add(Recipes(4, "Italian Soup"))
        arrSubCategory.add(Recipes(5, "Fries and Chicken"))

        subCategoryAdapter.setData(arrSubCategory)

        binding.rvMainCategory.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        binding.rvMainCategory.adapter = mainCategoryAdapter

        binding.rvSubCategory.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        binding.rvSubCategory.adapter = subCategoryAdapter


    }
}
package com.jeff.howto.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jeff.howto.R
import com.jeff.howto.databinding.ItemRvMainCategoryBinding
import com.jeff.howto.entities.Recipes

class MainCategoryAdapter : RecyclerView.Adapter<MainCategoryAdapter.RecipeViewHolder>(){

    var arrMainCategory = ArrayList<Recipes>()
    inner class RecipeViewHolder(private val my_view: ItemRvMainCategoryBinding):RecyclerView.ViewHolder(my_view.root){
        fun bind(currentItem: Recipes){
            my_view.tvDishName.text = currentItem.dishName



        }
    }

    fun setData(arrData : List<Recipes>){
        arrMainCategory = arrData as ArrayList<Recipes>
    }

    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): RecipeViewHolder {
        return RecipeViewHolder(ItemRvMainCategoryBinding.inflate(LayoutInflater.from(parent.context),parent,false
        ))
    }

    override fun onBindViewHolder(holder: RecipeViewHolder,position: Int) {
        holder.bind(arrMainCategory[position])
    }

    override fun getItemCount(): Int {
        return arrMainCategory.size
    }
}
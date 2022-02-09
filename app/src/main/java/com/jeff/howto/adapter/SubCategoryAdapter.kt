package com.jeff.howto.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jeff.howto.R
import com.jeff.howto.databinding.ItemRvMainCategoryBinding
import com.jeff.howto.databinding.ItemRvSubCategoryBinding
import com.jeff.howto.entities.Recipes

class SubCategoryAdapter : RecyclerView.Adapter<SubCategoryAdapter.RecipeViewHolder>(){

    var arrSubCategory = ArrayList<Recipes>()
    inner class RecipeViewHolder(private val my_view: ItemRvSubCategoryBinding):RecyclerView.ViewHolder(my_view.root){
       fun bind(currentItem: Recipes){
           my_view.tvDishName.text = currentItem.dishName



       }
    }

    fun setData(arrData : List<Recipes>){
        arrSubCategory = arrData as ArrayList<Recipes>
    }

    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): RecipeViewHolder {
        return RecipeViewHolder(ItemRvSubCategoryBinding.inflate(LayoutInflater.from(parent.context),parent,false
        ))
    }

    override fun onBindViewHolder(holder: RecipeViewHolder,position: Int) {
        holder.bind(arrSubCategory[position])
    }

    override fun getItemCount(): Int {
        return arrSubCategory.size
    }
}
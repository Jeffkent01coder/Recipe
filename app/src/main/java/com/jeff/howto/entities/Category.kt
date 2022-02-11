package com.jeff.howto.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.jeff.howto.entities.conveter.CategoryListConverter

@Entity(tableName = "Category")
data class Category(
    @PrimaryKey(autoGenerate = true)
    var id:Int,

    @ColumnInfo(name = "categories" )
    @Expose
    @SerializedName("categories")
    @TypeConverters(CategoryListConverter::class)
    val categories: List<CategoryX>? = null
)
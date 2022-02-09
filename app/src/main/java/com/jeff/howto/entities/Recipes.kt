package com.jeff.howto.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "Recipes")
data class Recipes (

    @PrimaryKey(autoGenerate = true)
    var id:Int

        ): Serializable

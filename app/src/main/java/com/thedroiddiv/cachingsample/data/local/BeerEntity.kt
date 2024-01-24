package com.thedroiddiv.cachingsample.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("beer_record")
class BeerEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val tagline: String,
    val firstBrewed: String,
    val description: String,
    val imageUrl: String
)
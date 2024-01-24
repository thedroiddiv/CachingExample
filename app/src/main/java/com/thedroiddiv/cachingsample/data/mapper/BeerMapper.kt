package com.thedroiddiv.cachingsample.data.mapper

import com.thedroiddiv.cachingsample.data.local.BeerEntity
import com.thedroiddiv.cachingsample.data.models.BeerDto
import com.thedroiddiv.cachingsample.domain.models.Beer

fun BeerDto.toBeerEntity() : BeerEntity {
    return BeerEntity(
        id = id,
        name = name,
        tagline = tagline,
        description = description,
        firstBrewed = first_brewed,
        imageUrl = image_url
    )
}

fun BeerEntity.toBeer() : Beer {
    return Beer(
        id = id,
        name = name,
        tagline = tagline,
        description = description,
        firstBrewed = firstBrewed,
        imageUrl = imageUrl
    )
}
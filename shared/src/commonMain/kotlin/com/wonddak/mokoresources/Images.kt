package com.wonddak.mokoresources

import dev.icerock.moko.resources.ImageResource

fun getImage() : ImageResource {
    return SharedRes.images.image
}

fun getClose() : ImageResource {
    return SharedRes.images.close
}
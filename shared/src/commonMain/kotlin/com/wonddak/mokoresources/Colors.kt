package com.wonddak.mokoresources

import dev.icerock.moko.resources.ColorResource

fun getValueColor() : ColorResource {
    return SharedRes.colors.valueColor
}

fun getReferenceColor() : ColorResource {
    return SharedRes.colors.referenceColor
}

fun getThemeColor() : ColorResource {
    return SharedRes.colors.themedColor
}
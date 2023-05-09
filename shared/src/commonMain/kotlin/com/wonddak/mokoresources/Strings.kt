package com.wonddak.mokoresources

import dev.icerock.moko.resources.desc.StringDesc
import dev.icerock.moko.resources.desc.desc
import dev.icerock.moko.resources.format

fun getMyDesc(): StringDesc {
    return SharedRes.strings.test.desc()
}
fun getMyFormatDesc(input: String): StringDesc {
    return SharedRes.strings.test_format.format(input)
}

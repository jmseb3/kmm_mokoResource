package com.wonddak.mokoresources

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
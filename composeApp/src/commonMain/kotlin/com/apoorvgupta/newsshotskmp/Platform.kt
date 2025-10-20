package com.apoorvgupta.newsshotskmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform

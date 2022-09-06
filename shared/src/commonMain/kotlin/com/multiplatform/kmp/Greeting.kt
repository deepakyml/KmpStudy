package com.multiplatform.kmp

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}
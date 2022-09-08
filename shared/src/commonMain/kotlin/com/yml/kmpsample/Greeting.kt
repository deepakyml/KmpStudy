package com.yml.kmpsample

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}
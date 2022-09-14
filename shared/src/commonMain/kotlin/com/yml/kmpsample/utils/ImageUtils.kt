package com.yml.kmpsample.utils

import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kotlin.random.Random

class ImageUtils {

    fun getInitialsAsAvatar(string: String): String {
        return "https://avatars.dicebear.com/api/initials/$string.png"
    }

    fun getTodaysBotAvatar(): String {
        return "https://avatars.dicebear.com/api/bottts/${Clock.System.now().toLocalDateTime(
            TimeZone.currentSystemDefault()).date}.png"
    }

    fun getAblurredBackgroundImage(): String {
        return "https://picsum.photos/1170/2532/?blur=8"
    }

    fun getAFullScreenImage(): String {
        return "https://picsum.photos/1170/2532"
    }


}
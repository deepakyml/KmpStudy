package com.yml.kmpsample.utils

class ColorUtils {
    companion object{
        val algaeBlue ="#395B64"
        val algaeGreen ="#3F4E4F"
        val brownMagenta ="#774360"
        val cementBlue ="#51557E"
        val darkPurple ="#4C3575"
        val darkMagenta ="#570A57"
        val darkNavyBlue ="#16003B"
        val black ="#000000"
        val brown ="#362222"
        val darkGray ="#393E46"
        val darkGreen ="#02383C"

        val pallet = arrayOf(
            algaeBlue, algaeGreen, brownMagenta, cementBlue, darkPurple,
            darkMagenta, darkNavyBlue, black, brown, darkGray, darkGreen
        )
    }

    fun getARandomDarkColor() = pallet[(pallet.indices).random()]

}
package com.jay.commons.widget

interface FontStyle {
    companion object {
        const val FONT_POPPINS_REGULAR = 1
        const val FONT_POPPINS_MEDIUM = 2
        const val FONT_POPPINS_SEMI_BOLD = 3
        const val FONT_POPPINS_BOLD = 4
        const val FONT_POPPINS_LIGHT = 5

        fun getFont(fontStyle: Int): String {
            return when (fontStyle) {
                FONT_POPPINS_REGULAR -> "fonts/Poppins-Bold.ttf"
                FONT_POPPINS_MEDIUM -> "fonts/Poppins-Medium.ttf"
                FONT_POPPINS_SEMI_BOLD -> "fonts/Poppins-SemiBold.ttf"
                FONT_POPPINS_BOLD -> "fonts/Poppins-Bold.ttf"
                FONT_POPPINS_LIGHT -> "fonts/Poppins-Light.ttf"
                else -> "fonts/Poppins-Bold.ttf"
            }
        }
    }
}
package com.jay.commons.widget

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import android.widget.TextView
import com.jay.commons.R


class AppTextView : TextView {

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
        init(attrs)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(attrs)
    }

    constructor(context: Context) : super(context) {
        init(null)
    }

    private fun init(attrs: AttributeSet?) {
        if (!isInEditMode && attrs != null) {
            val typpedArray = context.obtainStyledAttributes(attrs, R.styleable.PoppinsFont)
            val fontStyle = typpedArray.getInt(R.styleable.PoppinsFont_textFontStyle, FontStyle.FONT_POPPINS_REGULAR)

            val tf = Typeface.createFromAsset(context.assets, FontStyle.getFont(fontStyle))
            typeface = tf
        }
    }
}
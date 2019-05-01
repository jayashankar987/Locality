package com.jay.commons.extensions

import android.content.Context
import android.widget.Toast

infix fun Context.toast(text: String?) = Toast.makeText(this, text, Toast.LENGTH_LONG).show()
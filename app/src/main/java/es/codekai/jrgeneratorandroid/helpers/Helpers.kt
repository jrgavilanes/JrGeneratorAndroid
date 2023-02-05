package es.codekai.jrgeneratorandroid.helpers // ktlint-disable filename

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager

// Constants
const val ME = "me"
const val BOT = "bot"

// Extensions
fun View.hideKeyboard() {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(windowToken, 0)
}

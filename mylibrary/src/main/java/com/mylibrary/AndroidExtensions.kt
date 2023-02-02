package com.mylibrary

import android.content.Context
import android.content.Intent
import androidx.fragment.app.FragmentManager

// start fire and forget activity
inline fun <reified T> Context.gotoActivity(
    clearStack: Boolean = false,
    intentPacking: ((Intent) -> Unit) = {},
) {
    val intent = Intent(this, T::class.java)
    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK

    if (clearStack) {
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
    }

    intentPacking(intent)
    intentPacking.invoke(intent)
    startActivity(intent)
}

fun FragmentManager.clearBackStack() {
    for (i in 0 until this.backStackEntryCount) {
        this.popBackStack()
    }
}
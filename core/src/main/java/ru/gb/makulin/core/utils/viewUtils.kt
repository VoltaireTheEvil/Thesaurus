package ru.gb.makulin.core.utils

import android.view.View
import com.google.android.material.snackbar.Snackbar
import ru.gb.makulin.core.ON_FAILED_DATA_LOADING_TEXT
import ru.gb.makulin.core.SNACK_ACTION_TEXT

fun View.makeSnackbar(text: String, actionText: String, action: View.OnClickListener) {
    Snackbar.make(this, text, Snackbar.LENGTH_LONG).setAction(actionText, action).show()
}

fun View.makeErrSnackbar(action: View.OnClickListener) {
    Snackbar.make(this, ON_FAILED_DATA_LOADING_TEXT, Snackbar.LENGTH_LONG).setAction(
        SNACK_ACTION_TEXT, action
    ).show()
}

package com.reisdeveloper.cryptocurrencymvvm.presenter.extensions

import android.view.View
import androidx.databinding.BindingAdapter

fun View.hide() {
    if (visibility != View.GONE) {
        visibility = View.GONE
    }
}

@BindingAdapter("hide")
fun setHide(visible: Boolean) = if (visible) View.VISIBLE else View.GONE
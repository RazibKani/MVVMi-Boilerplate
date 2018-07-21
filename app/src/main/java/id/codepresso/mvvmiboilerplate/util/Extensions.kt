package id.codepresso.mvvmiboilerplate.util

import android.view.View
import android.widget.ImageView
import com.squareup.picasso.Picasso

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun View.hide() {
    visibility = View.GONE
}

fun ImageView.loadImage(url: String) {
    Picasso.with(this.context).load(url).into(this)
}
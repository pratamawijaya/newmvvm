package newmvvm.common.extensions

import android.widget.ImageView
import com.squareup.picasso.Picasso

fun ImageView.loadFromUrl(url: String) {
    if (url.isEmpty()) return
    Picasso.get().load(url).into(this)
}
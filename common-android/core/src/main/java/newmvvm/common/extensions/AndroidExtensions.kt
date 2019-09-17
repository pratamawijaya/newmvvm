package newmvvm.common.extensions

import android.widget.ImageView
import coil.api.load

fun ImageView.loadFromUrl(url: String) {
    if (url.isEmpty()) return
    // load image from url with coil
    this.load(url)
}

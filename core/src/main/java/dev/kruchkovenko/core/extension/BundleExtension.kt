package dev.kruchkovenko.core.extension

import android.os.Build.VERSION.SDK_INT
import android.os.Bundle
import android.os.Parcelable

object BundleExtension {
    inline fun <reified T: Parcelable> Bundle.parsable(key: String): T? = when{
        SDK_INT >= 33 -> this.getParcelable(key, T::class.java)
        else -> @Suppress("DEPRECATION") getParcelable(key)  as T?
    }
}

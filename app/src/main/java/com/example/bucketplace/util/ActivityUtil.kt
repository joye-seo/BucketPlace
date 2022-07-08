package com.example.bucketplace.util

import android.app.Activity
import android.content.Intent

object ActivityUtil {

    /**
     * 액티비티 네비게이터.
     *
     */
    inline fun <reified T : Activity> Activity.bucketPlaceStartActivity(block: (Intent) -> Unit) =
        Intent(this, T::class.java)
            .apply {
                block(this)
            }
            .let(::startActivity)
            .also {
                finish()
            }
}
package com.yoesuv.switchlanguage.utils

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class BaseActivity: AppCompatActivity() {

    override fun attachBaseContext(newBase: Context?) {
        val locale = Locale("in")
        val context = ContextWrapper.wrap(newBase!!, locale)
        super.attachBaseContext(newBase)
    }
}
package com.yoesuv.switchlanguage.utils

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.yoesuv.switchlanguage.data.LanguagePreferences
import java.util.*

abstract class BaseActivity: AppCompatActivity() {

    override fun attachBaseContext(newBase: Context?) {
        val locale = Locale(LanguagePreferences.appLanguage)
        val context = ContextWrapper.wrap(newBase!!, locale)
        super.attachBaseContext(context)
    }
}
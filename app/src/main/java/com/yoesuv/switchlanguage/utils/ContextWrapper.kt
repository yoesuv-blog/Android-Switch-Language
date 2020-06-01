package com.yoesuv.switchlanguage.utils

import android.content.Context
import android.os.Build
import android.os.LocaleList
import java.util.*

class ContextWrapper(base: Context) : android.content.ContextWrapper(base) {

    companion object {
        fun wrap(context: Context, newLocale: Locale): ContextWrapper {
            var mContext = context
            val res = mContext.resources
            val configuration = res.configuration

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                configuration.setLocale(newLocale)
                val localeList = LocaleList(newLocale)
                LocaleList.setDefault(localeList)
                mContext = mContext.createConfigurationContext(configuration)
            } else {
                configuration.locale = newLocale
                res.updateConfiguration(configuration, res.displayMetrics)
            }

            return ContextWrapper(mContext)
        }
    }
}
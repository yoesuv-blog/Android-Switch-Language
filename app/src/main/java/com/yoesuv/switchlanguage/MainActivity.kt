package com.yoesuv.switchlanguage

import android.content.Intent
import android.os.Bundle
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.radiobutton.MaterialRadioButton
import com.yoesuv.switchlanguage.data.Language
import com.yoesuv.switchlanguage.data.LanguagePreferences
import com.yoesuv.switchlanguage.utils.BaseActivity

class MainActivity : BaseActivity() {

    private lateinit var toolbar: MaterialToolbar
    private lateinit var radioEnglish: MaterialRadioButton
    private lateinit var radioIndonesia: MaterialRadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.toolbarMain)
        radioEnglish = findViewById(R.id.radioEnglish)
        radioIndonesia = findViewById(R.id.radioIndonesia)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        radioEnglish.setOnClickListener {
            LanguagePreferences.appLanguage = Language.EN.name
            restartApp()
        }
        radioIndonesia.setOnClickListener {
            LanguagePreferences.appLanguage = Language.IN.name
            restartApp()
        }

        setupSelected()
    }

    private fun setupSelected() {
        if(LanguagePreferences.appLanguage == Language.EN.name) {
            radioEnglish.isChecked = true
        } else {
            radioIndonesia.isChecked = true
        }
    }

    private fun restartApp() {
        val intent = baseContext.packageManager.getLaunchIntentForPackage(baseContext.packageName)
        intent?.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        intent?.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        intent?.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
        finish()
    }
}

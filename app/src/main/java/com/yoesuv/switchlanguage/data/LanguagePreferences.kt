package com.yoesuv.switchlanguage.data

import com.chibatching.kotpref.KotprefModel

object LanguagePreferences : KotprefModel() {

    override val kotprefName: String = "pref_language"

    var appLanguage by stringPref(Language.EN.name)

}
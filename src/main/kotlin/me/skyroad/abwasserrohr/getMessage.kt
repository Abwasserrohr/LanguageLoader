package me.skyroad.abwasserrohr

fun getMessage(pack: String, lang: String, messageKey: String): String {
    return LanguageLoader.container.get(pack, lang, messageKey, null)
}

fun getMessage(pack: String, lang: String, messageKey: String, replaceMap: HashMap<String, String>): String {
    return LanguageLoader.container.get(pack, lang, messageKey, replaceMap)
}

package me.skyroad.abwasserrohr

import org.bukkit.entity.Player

fun getMessage(pack: String, lang: String, messageKey: String): String {
    return LanguageLoader.container.get(pack, lang, messageKey, null)
}

fun getMessage(pack: String, lang: String, messageKey: String, replaceMap: HashMap<String, String>): String {
    return LanguageLoader.container.get(pack, lang, messageKey, replaceMap)
}

fun Player.sendTranslatedMessage(pack: String, messageKey: String, sendPrefix: Boolean, replaceMap: HashMap<String, String>) {
    var message = ""
    val langCode = this.locale.split("_")[0]
    if (sendPrefix) { message += getMessage("general", langCode, "prefix") + " " }
    message += getMessage(pack, langCode, messageKey, replaceMap)
    this.sendMessage(message)
}

fun Player.sendTranslatedMessage(pack: String, messageKey: String, sendPrefix: Boolean = true) {
    var message = ""
    val langCode = this.locale.split("_")[0]
    if (sendPrefix) { message += getMessage("general", langCode, "prefix") + " " }
    message += getMessage(pack, langCode, messageKey)
    this.sendMessage(message)
}

fun sendMessage(player: Player, pack: String, messageKey: String, sendPrefix: Boolean, replaceMap: HashMap<String, String>) {
    player.sendTranslatedMessage(pack, messageKey, sendPrefix, replaceMap)
}

fun sendMessage(player: Player, pack: String, messageKey: String, sendPrefix: Boolean = true) {
    player.sendTranslatedMessage(pack, messageKey, sendPrefix)
}

fun sendMessage(player: Player, pack: String, messageKey: String) {
    player.sendTranslatedMessage(pack, messageKey)
}

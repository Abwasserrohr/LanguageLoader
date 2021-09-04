package me.skyroad.abwasserrohr

import org.bukkit.entity.Player

fun getLangCode(player: Player): String {
    return player.langCode()
}

fun Player.langCode(): String {
    return this.locale.split("_")[0]
}

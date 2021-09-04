package me.skyroad.abwasserrohr

import me.skyroad.abwasserrohr.language.LanguageContainer
import org.bukkit.plugin.Plugin
import org.bukkit.plugin.java.JavaPlugin
import java.io.File

class LanguageLoader: JavaPlugin() {

    companion object {
        lateinit var instance: Plugin
        lateinit var container: LanguageContainer
        lateinit var pluginFolder: File
        var fallbackLanguageCode: String = "en"
        val packs: ArrayList<String> = arrayListOf()
        var onlyLocal = false
    }

    override fun onEnable() {
        saveDefaultConfig()

        onlyLocal = config.getBoolean("localload")
        packs.addAll(config.getStringList("loadpacks"))

        config.getString("fallbackCode")?.let { fallbackLanguageCode = it }

        pluginFolder = dataFolder
        instance = this
        container = LanguageContainer()

    }

    override fun onDisable() {
    }
}

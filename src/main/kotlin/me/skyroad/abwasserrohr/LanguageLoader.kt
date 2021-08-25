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
        val packs: ArrayList<String> = arrayListOf()
    }

    override fun onEnable() {
        saveDefaultConfig()

        packs.addAll(config.getStringList("loadpacks"))

        pluginFolder = dataFolder
        instance = this
        container = LanguageContainer()

    }

    override fun onDisable() {
    }
}

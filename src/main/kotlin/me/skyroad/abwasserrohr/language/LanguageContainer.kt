package me.skyroad.abwasserrohr.language

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import me.skyroad.abwasserrohr.LanguageLoader
import org.yaml.snakeyaml.Yaml
import java.net.URL


class LanguageContainer {
    private val loadedPacks = hashMapOf<String, String>()
    // HashMap<Pack,HashMap<LanguageCode,HashMap<MessageKey, MessageString>>>
    private val container: HashMap<String,HashMap<String, HashMap<String, String>>> = hashMapOf()

    init {

        println("[LanguageLoader] Trying to load language packs: ${LanguageLoader.packs}")

        val packList = URL("https://skyroad.me/dl/lang.json").readText(Charsets.UTF_8)
        val availablePacks = Json.decodeFromString<LanguagePacks>(packList)

        LanguageLoader.packs.forEach { requestedPack ->
            if (requestedPack == "all") {
                availablePacks.packs.forEach { pack ->
                    loadedPacks[pack.key] = pack.value
                }
            } else {
                availablePacks.packs.forEach { pack ->
                    if (pack.key == requestedPack) {
                        loadedPacks[pack.key] = pack.value
                    }
                }
            }
        }
        var loadedMessages = 0
        loadedPacks.forEach { pack ->

            val yaml = Yaml()
            val languages = yaml.load<Map<String, ArrayList<String>>>(URL(pack.value).readText(Charsets.UTF_8))
            (languages["languages"])?.forEach { languageCode ->
                val packURL = pack.value.replace(".yml", "_$languageCode.yml")
                val data = yaml.load<Map<String, String>>(URL(packURL).readText(Charsets.UTF_8))

                container[pack.key] = container[pack.key] ?: hashMapOf()

                val languageContainer = container[pack.key]?.get(languageCode) ?: hashMapOf()
                container[pack.key]?.set(languageCode, languageContainer)

                container[pack.key]?.get(languageCode)?.let {
                    data.forEach { languageData ->
                        it[languageData.key] = languageData.value
                        loadedMessages++
                    }
                }
            }
        }
        println("[LanguageLoader] Loaded $loadedMessages messages.")
    }

    fun get(pack: String, lang: String, messageKey: String, replaceMap: HashMap<String, String>?): String {
        container[pack]?.get(lang)?.get(messageKey)?.let {
            var message = it
            replaceMap?.forEach { replaceValue ->
                message = message.replace(replaceValue.key, replaceValue.value)
            }
            return message
        }
        return "[missing: \"$pack\" \"$lang\" \"$messageKey\"]"
    }
}

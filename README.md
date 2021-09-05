# LanguageLoader

LanguageLoader is meant to be used for almost all messages on our Minecraft server. This allows fast distribution of changes and easy implementation in all our projects.

## Usage Example

Skript
```yaml
import:
  me.skyroad.abwasserrohr.GetMessageKt
  me.skyroad.abwasserrohr.GetLangCodeKt
  java.util.HashMap

command /test:
  trigger:
    # Option 1: Get Message.
    set {_langCode} to GetLangCodeKt.getLangCode(player)
    set {_msg} to GetMessageKt.getMessage("general", {_langCode}, "prefix")
    message "%{_msg}% Hello."
    
    # Get message and replace placeholders:
    set {_langCode} to GetLangCodeKt.getLangCode(player)
    set {_map} to new HashMap()
    {_map}.put("<player>", "Abwasserrohr")
    set {_msg} to GetMessageKt.getMessage("general", {_langCode}, "prefix", true, {_map})
    message "%{_msg}% Hello."
    
    # Option 2: Send message directly, automatically adding prefix:
    GetMessageKt.sendMessage(player, "general", "prefix")
    
    # Send message and replace placeholders using HashMap, adding prefix:
    set {_map} to new HashMap()
    {_map}.put("<player>", "Abwasserrohr")
    GetMessageKt.sendMessage(player, "bauevent", "playerNotFound", true, {_map})

```

Java
```java
import me.skyroad.abwasserrohr.GetMessageKt;
import me.skyroad.abwasserrohr.GetLangCodeKt;

String langCode = GetLangCodeKt.getLangCode(player);
String msg = GetMessageKt.getMessage("general", langCode, "prefix");

// Send message directly, automatically adding prefix:
GetMessageKt.sendMessage(player, "general", "prefix")

// Send message and replace placeholders using HashMap, adding prefix:
HashMap<String, String> map = new HashMap<String, String>();
map.put("<player>","Abwasserrohr");
GetMessageKt.sendMessage(player, "bauevent", "playerNotFound", true, map)
```

Kotlin
```kotlin
import me.skyroad.abwasserrohr.getMessage
import me.skyroad.abwasserrohr.getLangCode

val langCode = getLangCode(player)
val msg = getMessage("general", langCode, "prefix")

// Send message directly, automatically adding prefix:
player.sendTranslatedMessage("general", "prefix")

// Send message and replace placeholders, adding prefix:
player.sendTranslatedMessage("bauevent", "playerNotFound", true, hashMapOf(Pair("<player>", "Abwasserrohr")))
```

## Setup

```gradle
repositories {
    maven { url 'https://jitpack.io' }
}
dependencies {
    compileOnly 'com.github.Abwasserrohr:LanguageLoader:main-SNAPSHOT'
}
```

```xml
	<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>

	<dependency>
	    <groupId>com.github.Abwasserrohr</groupId>
	    <artifactId>LanguageLoader</artifactId>
	    <version>main-SNAPSHOT</version>
	    <scope>provided</scope>
	</dependency>
```

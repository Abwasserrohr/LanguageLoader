# LanguageLoader

LanguageLoader is meant to be used for almost all messages on our Minecraft server. This allows fast distribution of changes and easy implementation in all our projects.

## Usage Example

Skript
```yaml
import:
  me.skyroad.abwasserrohr.GetMessageKt
command /test:
  trigger:
    set {_msg} to GetMessageKt.getMessage("general", "de", "prefix")
    message "%{_msg}% Hello."
```

Java
```java
import me.skyroad.abwasserrohr.GetMessageKt;

String msg = GetMessageKt.getMessage("general", "de", "prefix")
```

Kotlin
```kotlin
import me.skyroad.abwasserrohr.getMessage

val msg = getMessage("general", "de", "prefix")
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
	</dependency>
```

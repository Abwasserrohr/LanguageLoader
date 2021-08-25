# LanguageLoader

Usage:

Skript
```
import:
  me.skyroad.abwasserrohr.GetMessageKt
command /test:
  trigger:
    set {_msg} to GetMessageKt.getMessage("general", "de", "prefix")
    message "%{_msg}% Hello."
```
